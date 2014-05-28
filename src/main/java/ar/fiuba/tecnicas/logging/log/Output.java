package ar.fiuba.tecnicas.logging.log;

/**
 * This interface abstract the functionality of writing the log.
 *
 */
public interface Output {

	/**
	 * This method is used to write a message pass as parameter in the configured output.
	 * @param message
	 */
	public void doPrint(String message);
	
}
