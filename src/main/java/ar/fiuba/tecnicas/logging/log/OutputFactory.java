package ar.fiuba.tecnicas.logging.log;


/**
 * This interface abstract the creation of new kinds of Outputs.
 * @author pablo
 *
 */
public interface OutputFactory {
	
	/**
	 * This functions returns an Output associated to the outputString pass as arg.
	 * @param outputString
	 * @return a new Output of the kind that the outputString says.
	 * @throws IllegalOutputPatternException in case of unknown outputString
	 */
	public Output makeOutputForOutputString(String outputString) throws IllegalOutputPatternException;
	
}
