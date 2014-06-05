package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.filter.Filter;
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
	 */
	public void log(Level level, String msg, Throwable exception, ExecutionContext executionContext, String loggerName);
	
	/**
	 * 
	 * @return output defined to log
	 */
	public Output getLogOutput();
	
	public void addFilter(Filter newFilter);
	
	public void setRegexpPattern(String newRegex);
}
