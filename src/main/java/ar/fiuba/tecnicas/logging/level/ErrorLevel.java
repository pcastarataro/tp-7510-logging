package ar.fiuba.tecnicas.logging.level;

public class ErrorLevel implements Level {

	private static ErrorLevel instance = new ErrorLevel();
	private ErrorLevel() {};
	
	public static ErrorLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lower(ErrorLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "ERROR";
	}

}
