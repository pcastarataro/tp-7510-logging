package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.level.Level;

/**
 * This interface abstract all the functionality of one log.
 * @author pablo
 *
 */
public interface Log {
	
	/**
	 * 
	 * @return the configuration assosiated to the Log.
	 */
	public LogConfiguration getLogConfiguration();
	
	/**
	 * This method execute the log if the level is valid.
	 * @param level
	 * @param msg
	 * @throws MinLevelIsLowerException
	 */
	public void log(Level level, String msg, ExecutionContext executionContext, String loggerName) throws MinLevelIsLowerException;
	
	/**
	 * 
	 * @return output defined to log
	 */
	public Output getLogOutput();
	
}
