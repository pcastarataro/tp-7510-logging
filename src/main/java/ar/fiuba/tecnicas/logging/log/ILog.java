package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.ILogConfiguration;
import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import ar.fiuba.tecnicas.logging.filter.IFilter;
import ar.fiuba.tecnicas.logging.level.ILevel;

/**
 * This interface abstract all the functionality of one log.
 * @author pablo
 *
 */
public interface ILog {
	
	/**
	 * 
	 * @return the configuration assosiated to the Log.
	 */
	public ILogConfiguration getLogConfiguration();
	
	/**
	 * This method execute the log if the level is valid.
	 * @param level
	 * @param msg
	 */
	public void log(ILevel level, String msg, Throwable exception, IExecutionContext executionContext, String loggerName);
	
	/**
	 * 
	 * @return output defined to log
	 */
	public IOutput getLogOutput();
	
	public void addFilter(IFilter newFilter);
	
	public void setRegexpPattern(String newRegex);
	
	public String getAsXml();
}
