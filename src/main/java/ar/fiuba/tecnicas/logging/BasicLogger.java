package ar.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.MinLevelIsLowerException;


/**
 * This is the main class of the logging system. 
 * @author pablo
 *
 */
public class BasicLogger implements Logger{
	
	private List<Log> logs;
	
	public BasicLogger() {
		logs = new ArrayList<Log>();
	}
	
	public void addLog(Log log) {
		// si log es no nulo
		logs.add(log);
	}
	

	public void log(Level loggingLevel, String message) {
		for (Log log : logs) {
			doLog(log, loggingLevel, message);
		}
	}
	
	private void doLog(Log log, Level loggingLevel, String message) {
		try {
			log.log(loggingLevel, message);	
		}
		catch(MinLevelIsLowerException ex) {
			System.err.println("Min Level: " + log.getLogConfiguration().getMinLoggingLevel().getName() +
					" - " + "Level: " + loggingLevel.getName() + " - " + message);
		}
	}
}
