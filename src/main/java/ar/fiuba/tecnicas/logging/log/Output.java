package ar.fiuba.tecnicas.logging.log;

/**
 * This interface abstract the functionality of writing the log.
 *
 */
public interface Output {

	/**
	 * This method is used to configure the Output with the outputString passed as arg.
	 * @param outputString
	 * @throws IllegalOutputPatternException in case of invalid outputString.
	 */
	public void setOutputString(String outputString) throws IllegalOutputPatternException;
	
	/**
	 * This method is used to write a message pass as parameter in the configured output.
	 * @param message
	 */
	public void doPrint(String message);
	
}
