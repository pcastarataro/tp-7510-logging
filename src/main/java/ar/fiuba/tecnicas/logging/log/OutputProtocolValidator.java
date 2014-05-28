package ar.fiuba.tecnicas.logging.log;

/**
 * This class was created to make the validation of the protocols 
 * that comes on the outputString.
 * @author pablo
 *
 */
public class OutputProtocolValidator {

	/**
	 * This method compare the protocol associated to the outputString with the expected one.
	 * In case mismatch throws an IllegalOutputPatternException. 
	 * @param expectedProtocol
	 * @param outputString
	 * @throws IllegalOutputPatternException
	 */
	public static void validate(String expectedProtocol, 
			String outputString) throws IllegalOutputPatternException{
		try {
			
			int patternInitialPosition = 0;
			int patternFinalPosition = expectedProtocol.length();
			
			String outputStringPattern = outputString.substring(patternInitialPosition , 
					patternFinalPosition );
			if(!expectedProtocol.equals(outputStringPattern))
				throw new IllegalOutputPatternException();			
		}
		catch(IndexOutOfBoundsException e) {
			throw new IllegalOutputPatternException();
		}
	}
	
}