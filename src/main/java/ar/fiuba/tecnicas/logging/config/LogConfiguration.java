package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;

public interface LogConfiguration {
		
	public String getBaseFormat();
	public Level getMinLoggingLevel();
	public String getDelimiter();
}
