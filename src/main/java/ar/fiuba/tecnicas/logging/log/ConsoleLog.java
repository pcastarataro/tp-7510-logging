package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;

/**
 * This class implements a Log that contains a ConsoleOutput.
 * @author pcastarataro
 *
 */
public class ConsoleLog extends AbstractLog {
	
	LogOutput logOutput;

	public ConsoleLog(LogConfiguration logConfiguration) {
		super(logConfiguration);
		logOutput = new ConsoleLogOutput();
	}

	public LogOutput getLogOutput() {
		return logOutput;
	}
	
}
