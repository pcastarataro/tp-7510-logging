package ar.fiuba.tecnicas.logging.format;

/**
 * This class is an implementation of Formatter that allows to format of all ocurrences
 * of delimiters in ans string 
 * @author pcastarataro
 *
 */
public class DelimiterFormatter extends AbstractFormatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String delimiter = (String)parameters.getParameterNamed("delimiter");
		return baseFormat.replace("%n", delimiter);
	}

}
