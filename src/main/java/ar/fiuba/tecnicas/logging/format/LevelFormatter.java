package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.level.Level;

public class LevelFormatter extends AbstractFormatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		Level level = (Level)parameters.getParameterNamed("level");
		return baseFormat.replace("%p", level.getName());
	}

}
