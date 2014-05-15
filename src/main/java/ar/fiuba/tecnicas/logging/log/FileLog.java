package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;

/**
 * This class implements a log that has a FileOutput.
 * @author pcastarataro
 *
 */
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
