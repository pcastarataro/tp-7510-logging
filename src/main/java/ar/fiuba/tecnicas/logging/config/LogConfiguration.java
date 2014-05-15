package ar.fiuba.tecnicas.logging.config;

import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.log.LogOutput;

public interface LogConfiguration {
		
	public String getBaseFormat();
	public Level getMinLoggingLevel();
	public String getDelimiter();
	public String fileOutput();
}
