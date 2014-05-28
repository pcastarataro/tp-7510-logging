package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;

/**
 * Implements a specific LogConfiguration Class
 */
public class ConcreteLogConfiguration implements LogConfiguration {
	
	private String DEFAULT_DELIMITER = "-";
	
	private String baseFormat;
	private Level minLoggingLevel;
	private String outputString;
	
	/**
	 * @param baseFormat string pattern to log
	 * @param minLoggingLevel minimum Level to log
	 */
	public ConcreteLogConfiguration(String baseFormat, Level minLoggingLevel) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
	};
	
	/**
	 * @param baseFormat string pattern to log
	 * @param minLoggingLevel minimum Level to log
	 * @param outputString log output
	 */
	public ConcreteLogConfiguration(String baseFormat, Level minLoggingLevel, String outputString) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
		this.setOutputString(outputString);
	};
	
	/**
	 * @param baseFormat string pattern to log
	 * @param minLoggingLevel minimum Level to log
	 * @param outputString log output
	 * @param delimiter delimiter to be used to log. If not defined default "-"
	 */
	public ConcreteLogConfiguration(String baseFormat, Level minLoggingLevel, String outputString,String delimiter) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
		this.setOutputString(outputString);
		DEFAULT_DELIMITER=delimiter;
	};
	
	protected void setBaseFormat(String baseFormat) {
		this.baseFormat = baseFormat;
	}
	
	protected void setMinLoggingLevel(Level minLoggingLevel) {
		this.minLoggingLevel = minLoggingLevel;
	}
	
	protected void setOutputString(String outputString) {
		this.outputString = outputString;
	}
	
	public String getBaseFormat() {
		return this.baseFormat;
	}
	
	public Level getMinLoggingLevel() {
		return this.minLoggingLevel;
	}

	public String getDelimiter() {
		return DEFAULT_DELIMITER;
	}

	public String outputString() {
		return this.outputString;
	}
	
	public String getAsXml(){
		String xmlConfig="<log>";
		xmlConfig+="<level>"+this.minLoggingLevel.getName().replace("Level", "")+"</level>";
		xmlConfig+="<baseformat>" + this.baseFormat + "</baseformat>";
		xmlConfig+="<outputstring>" + this.outputString + "</outputstring>";
		xmlConfig+="<delimiter>" + this.DEFAULT_DELIMITER + "</delimiter>";
		xmlConfig+="</log>";
		return xmlConfig;
	}
}
