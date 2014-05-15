package ar.fiuba.tecnicas.logging.format;

/**
 *  This class is an implementation for Formatter that allows to make the format of all ocurrences of
 *  escaped % caracters in one string.
 * @author pcastarataro
 *
 */
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
