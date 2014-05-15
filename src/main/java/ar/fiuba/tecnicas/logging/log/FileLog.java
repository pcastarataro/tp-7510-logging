package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;

public class FileLog extends AbstractLog {

	LogOutput logOutput;

	public FileLog(LogConfiguration logConfiguration) {
		super(logConfiguration);
		logOutput = new FileLogOutput(logConfiguration.fileOutput());
	}
	
	public LogOutput getLogOutput() {
		return logOutput;
	}
}
