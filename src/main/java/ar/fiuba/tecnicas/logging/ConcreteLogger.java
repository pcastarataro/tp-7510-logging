package ar.fiuba.tecnicas.logging;

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
	
	/**
	 * Constructor of an concrete implementation of Logger
	 */
	public ConcreteLogger() {
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
		Level level = new ConcreteLevel(loggingLevel);
		for (Log log : logs) {
			doLog(log, level, message, executionContext);
		}
	}
	
	private void doLog(Log log, Level loggingLevel, String message, ExecutionContext executionContext) {
		try {
			log.log(loggingLevel, message, executionContext);	
		}
		catch(MinLevelIsLowerException ex) {
			System.err.println("Min Level: " + log.getLogConfiguration().getMinLoggingLevel().getName() +
					" - " + "Level: " + loggingLevel.getName() + " - " + message);
		}
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
}
