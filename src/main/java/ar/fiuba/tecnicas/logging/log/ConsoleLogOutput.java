package ar.fiuba.tecnicas.logging.log;

/**
 * This class implements an output that writes logs in the System Console.
 *
 */
public class ConsoleLogOutput implements LogOutput {

	public void doPrint(String message) {
		System.out.println(message);
	}

}
