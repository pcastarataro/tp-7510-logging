package ar.fiuba.tecnicas.logging.log;

import java.util.Date;
import java.util.List;

import ar.fiuba.tecnicas.logging.FormatterRepository;
import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.format.ConcreteLogParameter;
import ar.fiuba.tecnicas.logging.format.Formatter;
import ar.fiuba.tecnicas.logging.format.LogParameter;
import ar.fiuba.tecnicas.logging.level.Level;

public abstract class AbstractLog implements Log {
	private LogConfiguration logConfiguration;
	private ExecutionContext executionContext;
	private List<Formatter> formattersList;
	
	private void setLogConfiguration(LogConfiguration logConfiguration) {
		this.logConfiguration = logConfiguration;
	}
	
	protected AbstractLog(LogConfiguration logConfiguration) {
		this.setLogConfiguration(logConfiguration);
		
		FormatterRepository.getInstance().getFormatters();
		formattersList = FormatterRepository.getInstance().getFormatters();
	}

	public LogConfiguration getLogConfiguration() {
		return logConfiguration;
	}

	public void log(Level level, String message) {	
		testMinLevel(level);
		doLog(level, message);
	}
	
	private void testMinLevel(Level level) throws MinLevelIsLowerException{
		Level minLevel = this.getLogConfiguration().getMinLoggingLevel(); 
		if (!level.isLowerOrEqualsThan(minLevel)) {
			throw new MinLevelIsLowerException();
		}
	}
	
	private void doLog(Level level, String message) {
		executionContext = new LoggingExecutionContext();
		
		Date date = new Date();
		
		LogParameter logParameters = new ConcreteLogParameter(level, message, 
				executionContext, getLogConfiguration().getDelimiter() , date);
		
		String formattedMessage = this.getLogConfiguration().getBaseFormat();
		
		formattedMessage = preProcessFormats(logParameters, formattedMessage);
		formattedMessage = postProcessFormats(logParameters, formattedMessage);
		
		getLogOutput().doPrint(formattedMessage);
		
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
	
}
