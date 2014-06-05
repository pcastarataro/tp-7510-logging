package ar.fiuba.tecnicas.logging.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.fiuba.tecnicas.logging.FormatterRepository;
import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.filter.Filter;
import ar.fiuba.tecnicas.logging.filter.FilterNotMatchException;
import ar.fiuba.tecnicas.logging.format.ConcreteLogParameter;
import ar.fiuba.tecnicas.logging.format.Formatter;
import ar.fiuba.tecnicas.logging.format.LogParameter;
import ar.fiuba.tecnicas.logging.level.Level;

/**
 * This is a base class for a Log Implementation. This class do all the process of Logging using an abstract output that each derived class must provide.
 *
 */
public class ConcreteLog implements Log {
	private LogConfiguration logConfiguration;
	private Output logOutput;
	private List<Formatter> formattersList;
	
	private List<Filter> filtersList;
	private String regexPattern;

	/**
	 * @param logConfiguration configuration asociated to the log
	 * @param logOutput output defined to log
	 */
	public ConcreteLog(LogConfiguration logConfiguration, Output logOutput) {
		this.setLogConfiguration(logConfiguration);
		this.setLogOutput(logOutput);

		FormatterRepository.getInstance().getFormatters();
		formattersList = FormatterRepository.getInstance().getFormatters();
		
		filtersList = new ArrayList<>();
		regexPattern = null;
	}

	/**
	 * Returns the configuration
	 */
	public LogConfiguration getLogConfiguration() {
		return logConfiguration;
	}


	/**
	 * Resolve the logging in the current log
	 */
	public void log(Level level, String message, Throwable exception, ExecutionContext executionContext, String loggerName) {	
		doLog(level, message, exception, executionContext, loggerName);
	}

	/**
	 * Returns the Output associated to the Log
	 */
	public Output getLogOutput() {
		return logOutput;
	}

	private void doLog(Level level, String message, Throwable exception, ExecutionContext executionContext, String loggerName) {
		try {
			Date date = new Date();

			LogParameter logParameters = new ConcreteLogParameter(level, message, 
					executionContext, getLogConfiguration().getDelimiter() , date, loggerName);

			testRegex(regexPattern, message);
			testFilters(filtersList, logParameters);

			String formattedMessage = this.getLogConfiguration().getBaseFormat();
			formattedMessage = preProcessFormats(logParameters, formattedMessage);
			formattedMessage = postProcessFormats(logParameters, formattedMessage);
			
			if (exception != null){
				String stackTraceException = stackTraceExceptionMessage(exception);
				formattedMessage += " // " + stackTraceException;
			}

			getLogOutput().doPrint(formattedMessage);
		}
		catch(FilterNotMatchException ex) {}
	}

	private void testFilters(List<Filter> filters, LogParameter params) throws FilterNotMatchException {
		for (Filter filter : filters) {
			filter.testShouldLog(params);
		}
	}
	
	private void testRegex(String regexPattern, String msg) throws FilterNotMatchException {
		if(regexPattern == null || regexPattern.isEmpty())
			return;
		if(!msg.matches(regexPattern))
			throw new FilterNotMatchException();
	}

	private String preProcessFormats(LogParameter logParameters,
			String formattedMessage) {
		for (Formatter formatter : formattersList) {
			formattedMessage = formatter.preProcessFormat(formattedMessage, logParameters);
		}
		return formattedMessage;
	}

	private String postProcessFormats(LogParameter logParameters,
			String formattedMessage) {
		for (Formatter formatter : formattersList) {
			formattedMessage = formatter.postProcessFormat(formattedMessage, logParameters);
		}
		return formattedMessage;
	}

	private void setLogConfiguration(LogConfiguration logConfiguration) {
		this.logConfiguration = logConfiguration;
	}

	private void setLogOutput(Output logOutput) {
		this.logOutput = logOutput;
	}
	
	private String stackTraceExceptionMessage(Throwable exception)
	{
		StringWriter stackTrace = new StringWriter();
		exception.printStackTrace(new PrintWriter(stackTrace));
		
		return stackTrace.toString();
	}

}
