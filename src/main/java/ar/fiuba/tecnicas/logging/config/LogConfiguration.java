package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;

/**
 * Interface that define Log Configuration Class behaviour
 *
 */
public interface LogConfiguration {
		
	/**
	 * @return log patter defined in configuration file
	 */
	public String getBaseFormat();
		
	/**
	 * @return minimun Level defined in configuration file
	 */
	public Level getMinLoggingLevel();
	
	
	/**
	 * @return delimiter defined in configuration file. If not defined return default "-"
	 */
	public String getDelimiter();
	
	/**
	 * @return log output defined in configuration file
	 */
	public String outputString();
	
	/**
	 * @return configuration properties as XML
	 */
	public String getAsXml();
}
