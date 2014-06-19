package ar.fiuba.tecnicas.logging.log;

/**
 * This class implements an output that writes logs in the System Console.
 *
 */
public class ConsoleOutput implements IOutput {

	/*
	 * (non-Javadoc)
	 * @see ar.fiuba.tecnicas.logging.log.Output#doPrint(java.lang.String)
	 */
	public void doPrint(String message) {
		System.out.println(message);
	}

	/*
	 * (non-Javadoc)
	 * @see ar.fiuba.tecnicas.logging.log.Output#setOutputString(java.lang.String)
	 */
	public void setOutputString(String outputString)
			throws IllegalOutputPatternException {
		String fileOutputPattern = ConsoleOutput.class.getName() + ":";
		OutputProtocolValidator.validate(fileOutputPattern, outputString);
	}
	
	public String getAsXml(){
		return "<outputstring>"+this.getClass().getName()+":</outputstring>";
	}

}
