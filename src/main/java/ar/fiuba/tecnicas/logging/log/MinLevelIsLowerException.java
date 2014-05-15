package ar.fiuba.tecnicas.logging.log;

/**
 * This exceptions is used to indicates that the min level declared in the LogCongfiguration is 
 * lower than the one send with the message
 *
 */
public class MinLevelIsLowerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
