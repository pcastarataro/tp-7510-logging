package ar.fiuba.tecnicas.logging.format;


public class EscapeFormatter extends AbstractFormatter {

	private String preProcessorEscape = "*_%_*";
	
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		return baseFormat.replace("%%", preProcessorEscape);
	}
	
	@Override
	public String postProcessFormat(String baseFormat, LogParameter parameters) {
		return baseFormat.replace(preProcessorEscape, "%");
	}

}
