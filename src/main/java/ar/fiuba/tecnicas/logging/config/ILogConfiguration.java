package ar.fiuba.tecnicas.logging.config;

/**
 * Interface that define Log Configuration behaviour asociate to the configuration file
 *
 */
public interface ILogConfiguration {
		
	/**
	 * @return log pattern defined in configuration file
	 */
	public String getBaseFormat();
	
	
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
