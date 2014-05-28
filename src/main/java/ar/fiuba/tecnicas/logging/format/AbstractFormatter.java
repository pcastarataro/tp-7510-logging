package ar.fiuba.tecnicas.logging.format;

/**
 * This class make an abstract implementation of a logger.
 * @author pcastarataro
 *
 */
public abstract class AbstractFormatter implements Formatter {
	
	/**
	 * Implements the default behavior of post formating a message.
	 */
	public String postProcessFormat(String baseFormat, LogParameter parameters) {
		return baseFormat;
	}

}
