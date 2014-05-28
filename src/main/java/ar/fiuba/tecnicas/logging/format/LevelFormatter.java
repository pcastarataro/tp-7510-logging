package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.level.Level;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of Level  pattern in an string.
 * @author pcastarataro
 *
 */
public class LevelFormatter extends AbstractFormatter {

	/**
	 * Replace all the occurrences of Level pattern with the Logging level
	 */
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		Level level = (Level)parameters.getParameterNamed("level");
		return baseFormat.replace("%p", level.getName());
	}

}
