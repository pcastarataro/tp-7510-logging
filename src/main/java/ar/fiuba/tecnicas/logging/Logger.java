package ar.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.ILevel;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ILog;
import ar.fiuba.tecnicas.logging.log.MinLevelIsLowerException;


/**
 * Implementation of a specific main logger class of the logging system. 
 *
 */
public class Logger implements ILogger {
	
	private List<ILog> logs;
	private String name;
	private ILevel minLoggingLevel;
	/**
	 * Constructor of an concrete implementation of Logger
	 */
	public Logger(String name) {
		this.name = name;
		logs = new ArrayList<ILog>();
	}
	
	/**
	 * This method implements the addition of a new Log to the list of available logs.
	 */
	public void addLog(ILog log) {
		logs.add(log);
	}
	

	/**
	 * This method implements the interface log method that allow to log a new message
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message) {
		IExecutionContext executionContext =new LoggingExecutionContext();
		log(loggingLevel, message, null, executionContext);
	}
	
	/**
	 * This method implements the interface log method that allow to log a new message
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message, IExecutionContext executionContext) {
		log(loggingLevel, message, null, executionContext);
	}
	
	/**
	 * This method implements the interface log method that allow to log a message and exception trace
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message, Throwable exception) {
		IExecutionContext executionContext = new LoggingExecutionContext();
		log(loggingLevel, message, exception, executionContext);
	}

	/**
	 * This method implements the interface log method that allow to log a new message + exception trace
	 * in all the Logs configured in the current Logger.
	 */
	public void log(LevelPriority loggingLevel, String message, Throwable exception,
			IExecutionContext executionContext) {
		ILevel level = new Level(loggingLevel);
		try {
			testMinLevel(level);
			
			for (ILog log : logs) {
				doLog(log, level, message, exception, executionContext);
			}
		}catch(MinLevelIsLowerException ex) {
			System.err.println("Min Level: " + this.getMinLoggingLevel().getName() +
					" - " + "Level: " + level.getName() + " - " + message);
		}	
	}
	
	private void doLog(ILog log, ILevel loggingLevel, String message, Throwable exception, IExecutionContext executionContext) {
		log.log(loggingLevel, message, exception, executionContext, this.getName());	
	}
	
	/**
	 * Returns the configuration as XML
	 */
	public String getXmlConfig(){
		String xmlConfig="<logger name=\""+this.name+"\" level=\""+this.getMinLoggingLevel().getName()+"\">";
		int cantLogs=this.logs.size();
		for(int i=0;i<cantLogs;i++){
			xmlConfig+=this.logs.get(i).getAsXml();
		}
		xmlConfig+="</logger>";
		return xmlConfig;
	}

	/**
	 * This method return the logger name
	 * @return logger name
	 */
	public String getName() {
		return this.name;
	}
	
	public void setMinLoggingLevel(ILevel level){
		this.minLoggingLevel=level;
	}
	
	public ILevel getMinLoggingLevel(){
		return this.minLoggingLevel;
	}
	
	private void testMinLevel(ILevel level) throws MinLevelIsLowerException{
		ILevel minLevel = this.getMinLoggingLevel(); 
		if (!level.isLowerOrEqualsThan(minLevel)) {
			throw new MinLevelIsLowerException();
		}
	}
}
