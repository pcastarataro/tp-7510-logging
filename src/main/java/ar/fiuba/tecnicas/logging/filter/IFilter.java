package ar.fiuba.tecnicas.logging.filter;

import ar.fiuba.tecnicas.logging.format.ILogParameter;

/**
 * This interface makes an abstraction of Filters. 
 * A filter is a way to block some messages to be logged. 
 * Implementing classes that support this api, you will be able to 
 * extend the functionality of the Logger with your custom filters.
 *
 */
public interface IFilter {
	/**
	 * This method is used to set the configuration of the filter from a configuration string.
	 * In case of error it must throw an "InvalidConfigurationStringException". In other case, 
	 * it must configure the filter with the string. 
	 * @param configurationStr
	 * @throws InvalidConfigurationStringException
	 */
	public void setConfigurationString(String configurationStr) throws InvalidConfigurationStringException;
	
	/**
	 * This method must throw a "FilterNotMatchException" when the Filter don let to log the message.
	 *  
	 * @param logParams
	 * @throws FilterNotMatchException
	 */
	public void testShouldLog(ILogParameter logParams) throws FilterNotMatchException;
	
}
