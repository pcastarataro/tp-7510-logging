package ar.fiuba.tecnicas.logging.log;


public class ConsoleLogOutput implements LogOutput {

	public void doPrint(String message) {
		System.out.println(message);
	}

}
