package ar.fiuba.tecnicas.logging;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import ar.fiuba.tecnicas.logging.level.ILevel;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ILog;

/**
 *	Interface that define logger behavior
 */
public interface ILogger {

	/**
	 * This method add a new log with its specific output, log patter, min level... to the logger
	 * @param log to be used by the logger with its defined log parameters output, log patter, min level...
	 */
	public void addLog(ILog log);
	
	/**
	 * This method is used to log one message in all the Logs configured on the logger
	 * @param loggingLevel
	 * @param message
	 */
	public void log(LevelPriority loggingLevel, String message);
	
	/**
	 * This method is used to log one message in all the Logs configured on the logger.
	 * It uses the execution context to obtain the file, line, etc.
	 * @param loggingLevel
	 * @param message
	 * @param executionContext
	 */
	public void log(LevelPriority loggingLevel, String message, IExecutionContext executionContext);
	
	/**
	 * This method is used to log one message + exception trace in all the Logs configured on the logger
	 * @param loggingLevel
	 * @param message
	 * @param exception
	 */
	public void log(LevelPriority loggingLevel, String message, Throwable exception);
	
	/**
	 * This method is used to log one message + exception trace in all the Logs configured on the logger
	 * @param loggingLevel
	 * @param message
	 * @param exception
	 * @param executionContext
	 */
	public void log(LevelPriority loggingLevel, String message, 
			Throwable exception, IExecutionContext executionContext);
	
	/**
	 * This method is used to obtain the structure of the xml file configuration associated to the logger
	 * @return xml log configuration
	 */
	public String getXmlConfig();
	
	
	/**
	 * This method return the logger name
	 * @return logger name
	 */
	public String getName();

	/**
	 * Returns the min Level associated to the Logger.
	 * @return
	 */
	public ILevel getMinLoggingLevel();

	/**
	 * This method sets the minimum logging level for the Logger. 
	 * @param level
	 */
	public void setMinLoggingLevel(ILevel level);
	
}
