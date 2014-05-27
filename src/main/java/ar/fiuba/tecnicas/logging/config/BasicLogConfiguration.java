package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;

public class BasicLogConfiguration implements LogConfiguration {
	
	private String DEFAULT_DELIMITER = "-";
	
	private String baseFormat;
	private Level minLoggingLevel;
	private String fileOutput;
	
	public BasicLogConfiguration(String baseFormat, Level minLoggingLevel) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
	};
	
	public BasicLogConfiguration(String baseFormat, Level minLoggingLevel, String fileOutput) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
		this.setFileOutput(fileOutput);
	};
	
	public BasicLogConfiguration(String baseFormat, Level minLoggingLevel, String fileOutput,String delimiter) {
		this.setBaseFormat(baseFormat);
		this.setMinLoggingLevel(minLoggingLevel);
		this.setFileOutput(fileOutput);
		DEFAULT_DELIMITER=delimiter;
	};
	
	protected void setBaseFormat(String baseFormat) {
		this.baseFormat = baseFormat;
	}
	
	protected void setMinLoggingLevel(Level minLoggingLevel) {
		this.minLoggingLevel = minLoggingLevel;
	}
	
	protected void setFileOutput(String fileOutput) {
		this.fileOutput = fileOutput;
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

	public String fileOutput() {
		return this.fileOutput;
	}
	
	public String getAsXml(){
		String xmlConfig="<log>";
		xmlConfig+="<level>"+this.minLoggingLevel.getName().replace("Level", "")+"</level>";
		xmlConfig+="<baseformat>" + this.baseFormat + "</baseformat>";
		xmlConfig+="<filename>" + this.fileOutput + "</filename>";
		xmlConfig+="<delimiter>" + this.DEFAULT_DELIMITER + "</delimiter>";
		xmlConfig+="</log>";
		return xmlConfig;
	}
}
