package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;

/**
 * Implements a specific LogConfiguration Class
 */
public class ConcreteLogConfiguration implements LogConfiguration {
	
	private String DEFAULT_DELIMITER = "-";
	
	private String baseFormat;
	private String outputString;
	
	/**
	 * @param baseFormat string pattern to log
	 * @param minLoggingLevel minimum Level to log
	 */
	public ConcreteLogConfiguration(String baseFormat) {
		this.setBaseFormat(baseFormat);
	};
	
	/**
	 * @param baseFormat string pattern to log
	 * @param minLoggingLevel minimum Level to log
	 * @param outputString log output
	 */
	public ConcreteLogConfiguration(String baseFormat, String outputString) {
		this.setBaseFormat(baseFormat);
		this.setOutputString(outputString);
	};
	
	/**
	 * @param baseFormat string pattern to log
	 * @param minLoggingLevel minimum Level to log
	 * @param outputString log output
	 * @param delimiter delimiter to be used to log. If not defined default "-"
	 */
	public ConcreteLogConfiguration(String baseFormat, String outputString,String delimiter) {
		this.setBaseFormat(baseFormat);
		this.setOutputString(outputString);
		this.DEFAULT_DELIMITER=delimiter;
	};
	
	protected void setBaseFormat(String baseFormat) {
		this.baseFormat = baseFormat;
	}
	
	
	protected void setOutputString(String outputString) {
		this.outputString = outputString;
	}
	
	/**
	 * Retuns the base format
	 */
	public String getBaseFormat() {
		return this.baseFormat;
	}

	/**
	 * Returns the delimiter string
	 */
	public String getDelimiter() {
		return DEFAULT_DELIMITER;
	}

	/**
	 * Returns the output string
	 */
	public String outputString() {
		return this.outputString;
	}
	
	/**
	 * Return the log as XML
	 */
	public String getAsXml(){
		String xmlConfig="<log>";
		xmlConfig+="<baseformat>" + this.baseFormat + "</baseformat>";
		xmlConfig+="<outputstring>" + this.outputString + "</outputstring>";
		xmlConfig+="<delimiter>" + this.DEFAULT_DELIMITER + "</delimiter>";
		xmlConfig+="</log>";
		return xmlConfig;
	}
}
