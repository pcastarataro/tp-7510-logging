package ar.fiuba.tecnicas.logging.log;

/**
 * This class implements an output that writes logs in the System Console.
 *
 */
public class ConsoleOutput implements Output {

	public void doPrint(String message) {
		System.out.println(message);
	}

	public void setOutputString(String outputString)
			throws IllegalOutputPatternException {
		String fileOutputPattern = "console:";
		OutputProtocolValidator.validate(fileOutputPattern, outputString);
	}

}
