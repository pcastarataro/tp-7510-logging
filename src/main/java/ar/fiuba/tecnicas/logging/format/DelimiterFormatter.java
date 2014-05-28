package ar.fiuba.tecnicas.logging.format;

/**
 * This class is an implementation of Formatter that allows to format of all occurrences
 * of delimiters in as string 
 * @author pcastarataro
 *
 */
public class DelimiterFormatter extends AbstractFormatter {

	/**
	 * Replace all the occurrences of delimiter pattern with the configured delimiter
	 */
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String delimiter = (String)parameters.getParameterNamed("delimiter");
		return baseFormat.replace("%n", delimiter);
	}

}
