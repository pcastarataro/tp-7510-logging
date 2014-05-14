package ar.fiuba.tecnicas.logging.format;


public class MessageFormatter extends AbstractFormatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String message = (String)parameters.getParameterNamed("message");
		return baseFormat.replace("%m", message);
	}

}
