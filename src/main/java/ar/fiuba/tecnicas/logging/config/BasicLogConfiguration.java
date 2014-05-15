package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;

public class BasicLogConfiguration implements LogConfiguration {
	
	private final String DEFAULT_DELIMITER = "-";
	
	private String baseFormat;
	private Level minLoggingLevel;
	
	public BasicLogConfiguration(String baseFormat, Level minLoggingLevel) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
	};
	
	protected void setBaseFormat(String baseFormat) {
		this.baseFormat = baseFormat;
	}
	
	protected void setMinLoggingLevel(Level minLoggingLevel) {
		this.minLoggingLevel = minLoggingLevel;
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
}
