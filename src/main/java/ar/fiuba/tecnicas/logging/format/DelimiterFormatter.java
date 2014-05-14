package ar.fiuba.tecnicas.logging.format;


public class DelimiterFormatter extends AbstractFormatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String delimiter = (String)parameters.getParameterNamed("delimiter");
		return baseFormat.replace("%n", delimiter);
	}

}
