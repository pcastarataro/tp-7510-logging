package ar.fiuba.tecnicas.logging.format;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of Message  pattern in an string.
 * @author pcastarataro
 *
 */
public class MessageFormatter extends AbstractFormatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String message = (String)parameters.getParameterNamed("message");
		return baseFormat.replace("%m", message);
	}

}
