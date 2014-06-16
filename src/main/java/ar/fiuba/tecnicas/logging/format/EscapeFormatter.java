package ar.fiuba.tecnicas.logging.format;

/**
 *  This class is an implementation for Formatter that allows to make the format of all ocurrences of
 *  escaped % caracters in one string.
 * @author pcastarataro
 *
 */
public class EscapeFormatter extends AbstractFormatter {

	private String preProcessorEscape = "*_%_*";
	
	/**
	 * Replace all the occurrences of %% with an preProccesed % string.
	 */
	public String preProcessFormat(String baseFormat, ILogParameter parameters) {
		return baseFormat.replace("%%", preProcessorEscape);
	}
	
	/**
	 * Replace all the preProccesed % strings with %
	 */
	@Override
	public String postProcessFormat(String baseFormat, ILogParameter parameters) {
		return baseFormat.replace(preProcessorEscape, "%");
	}

}
