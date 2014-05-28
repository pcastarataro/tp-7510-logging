package ar.fiuba.tecnicas.logging;

import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.log.Log;

/**
 *	Interface that define logger behaviour
 */
public interface Logger {

	/**
	 * This method add a new log with its specific output, log patter, min level... to the logger
	 * @param log to be used by the logger with its defined log parameters output, log patter, min level...
	 */
	public void addLog(Log log);
	
	/**
	 * This method is used to log one message in all the Logs configured on the logger
	 * @param loggingLevel
	 * @param message
	 */
	public void log(Level loggingLevel, String message);
	
	/**
	 * This method is used to obtain the structure of the xml file configuration associated to the logger
	 * @return xml log configuration
	 */
	public String getXmlConfig();
	
}
