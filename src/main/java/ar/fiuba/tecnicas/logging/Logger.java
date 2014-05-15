package ar.fiuba.tecnicas.logging;

import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.log.Log;

public interface Logger {

	public void addLog(Log log);
	
	/**
	 * This method is used to log one message in all the Logs configured on the logger
	 * @param loggingLevel
	 * @param message
	 */
	public void log(Level loggingLevel, String message);
	
	public String getXmlConfig();
	
}
