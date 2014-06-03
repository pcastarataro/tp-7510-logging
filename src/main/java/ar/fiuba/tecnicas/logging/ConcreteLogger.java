package ar.fiuba.tecnicas.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.MinLevelIsLowerException;


/**
 * Implementation of a specific main logger class of the logging system. 
 *
 */
public class ConcreteLogger implements Logger {
	
	private List<Log> logs;
	private String name;
	private Level minLoggingLevel;
	/**
	 * Constructor of an concrete implementation of Logger
	 */
	public ConcreteLogger(String name) {
		this.name = name;
		logs = new ArrayList<Log>();
	}
	
	/**
	 * This method implements the addition of a new Log to the list of available logs.
	 */
	public void addLog(Log log) {
		logs.add(log);
	}
	

	/**
	 * This method implements the interface log method that allow to log a new message
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message) {
		ExecutionContext executionContext =new LoggingExecutionContext();
		log(loggingLevel, message, executionContext);
	}

	/**
	 * This method implements the interface log method that allow to log a new message
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message, 
			ExecutionContext executionContext) {
		Level level = new ConcreteLevel(loggingLevel);
		try {
			testMinLevel(level);
			for (Log log : logs) {
				doLog(log, level, message, executionContext);
			}
		}catch(MinLevelIsLowerException ex) {
			System.err.println("Min Level: " + this.getMinLoggingLevel().getName() +
					" - " + "Level: " + level.getName() + " - " + message);
		}	
	}
	
	private void doLog(Log log, Level loggingLevel, String message, ExecutionContext executionContext) {
		log.log(loggingLevel, message, executionContext, this.getName());	
	}
	
	/**
	 * Returns the configuration as XML
	 */
	public String getXmlConfig(){
		String xmlConfig="<logger>";
		int cantLogs=this.logs.size();
		for(int i=0;i<cantLogs;i++){
			xmlConfig+=this.logs.get(i).getLogConfiguration().getAsXml();
		}
		xmlConfig+="</logger>";
		return xmlConfig;
	}

	/**
	 * This method implements the interface log method that allow to log a message and exception trace
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message, Throwable exception) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		log(loggingLevel, message, exception, executionContext);
	}

	/**
	 * This method implements the interface log method that allow to log a message and exception trace
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message, 
			Throwable exception, ExecutionContext executionContext) {
		
		StringWriter stackTrace = new StringWriter();
		exception.printStackTrace(new PrintWriter(stackTrace));
		
		this.log(loggingLevel, message + " // " +  stackTrace.toString(),executionContext);
	}
	
	/**
	 * This method return the logger name
	 * @return logger name
	 */
	public String getName() {
		return this.name;
	}
	
	public void setMinLoggingLevel(Level level){
		this.minLoggingLevel=level;
	}
	
	public Level getMinLoggingLevel(){
		return this.minLoggingLevel;
	}
	
	private void testMinLevel(Level level) throws MinLevelIsLowerException{
		Level minLevel = this.getMinLoggingLevel(); 
		if (!level.isLowerOrEqualsThan(minLevel)) {
			throw new MinLevelIsLowerException();
		}
	}
	
}
