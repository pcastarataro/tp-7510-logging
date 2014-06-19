package ar.fiuba.tecnicas.logging.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import ar.fiuba.tecnicas.logging.FormatterRepository;
import ar.fiuba.tecnicas.logging.config.ILogConfiguration;
import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import ar.fiuba.tecnicas.logging.filter.IFilter;
import ar.fiuba.tecnicas.logging.filter.FilterNotMatchException;
import ar.fiuba.tecnicas.logging.format.LogParameter;
import ar.fiuba.tecnicas.logging.format.IFormatter;
import ar.fiuba.tecnicas.logging.format.ILogParameter;
import ar.fiuba.tecnicas.logging.level.ILevel;

/**
 * This is a base class for a Log Implementation. This class do all the process of Logging using an abstract output that each derived class must provide.
 *
 */
public class Log implements ILog {
	private ILogConfiguration logConfiguration;
	private IOutput logOutput;
	private List<IFormatter> formattersList;
	
	private List<IFilter> filtersList;
	private String regexPattern;

	/**
	 * @param logConfiguration configuration asociated to the log
	 * @param logOutput output defined to log
	 */
	public Log(ILogConfiguration logConfiguration, IOutput logOutput) {
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
	public ILogConfiguration getLogConfiguration() {
		return logConfiguration;
	}


	/**
	 * Resolve the logging in the current log
	 */
	public void log(ILevel level, String message, Throwable exception, IExecutionContext executionContext, String loggerName) {	
		doLog(level, message, exception, executionContext, loggerName);
	}

	/**
	 * Returns the Output associated to the Log
	 */
	public IOutput getLogOutput() {
		return logOutput;
	}

	private void doLog(ILevel level, String message, Throwable exception, IExecutionContext executionContext, String loggerName) {
		try {
			Date date = new Date();

			ILogParameter logParameters = new LogParameter(level, message, 
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

	private void testFilters(List<IFilter> filters, ILogParameter params) throws FilterNotMatchException {
		for (IFilter filter : filters) {
			filter.testShouldLog(params);
		}
	}
	
	private void testRegex(String regexPattern, String msg) throws FilterNotMatchException {
		if(regexPattern == null || regexPattern.isEmpty())
			return;
		if(!msg.matches(regexPattern))
			throw new FilterNotMatchException();
	}

	private String preProcessFormats(ILogParameter logParameters,
			String formattedMessage) {
		for (IFormatter formatter : formattersList) {
			formattedMessage = formatter.preProcessFormat(formattedMessage, logParameters);
		}
		return formattedMessage;
	}

	private String postProcessFormats(ILogParameter logParameters,
			String formattedMessage) {
		for (IFormatter formatter : formattersList) {
			formattedMessage = formatter.postProcessFormat(formattedMessage, logParameters);
		}
		return formattedMessage;
	}

	private void setLogConfiguration(ILogConfiguration logConfiguration) {
		this.logConfiguration = logConfiguration;
	}

	private void setLogOutput(IOutput logOutput) {
		this.logOutput = logOutput;
	}
	
	private String stackTraceExceptionMessage(Throwable exception)
	{
		StringWriter stackTrace = new StringWriter();
		exception.printStackTrace(new PrintWriter(stackTrace));
		
		return stackTrace.toString();
	}
	public void addFilter(IFilter newFilter){
		this.filtersList.add(newFilter);
	}
	
	public void setRegexpPattern(String newRegex){
		this.regexPattern=newRegex;
	}
	
	public String getAsXml(){
		String xml="<log>";
		//return this.logConfiguration.getAsXml();
		xml+="<baseformat>"+this.logConfiguration.getBaseFormat()+"</baseformat>";
		xml+=this.logOutput.getAsXml();
		xml+="<delimiter>"+this.logConfiguration.getDelimiter()+"</delimiter>";
		xml+=this.getFiltersAsXml();
		xml+="</log>";
		return xml;
	}
	
	private String getFiltersAsXml(){
		String xml="";
		if(this.regexPattern==null && this.filtersList.size()==0)return xml;
		xml+="<filters>";
		if(this.regexPattern!=null){
			xml+="<filterpattern>"+this.regexPattern+"</filterpattern>";
		}
		java.util.Iterator<IFilter> iterador=this.filtersList.iterator();
		while(iterador.hasNext()){
			IFilter filter=iterador.next();
			xml+=filter.getAsXml();
			//System.out.println(xml);
		}
		xml+="</filters>";
		return xml;
	}
}
