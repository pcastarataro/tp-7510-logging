package ar.fiuba.tecnicas.logging.level;

public class ErrorLevel implements Level {

	private static ErrorLevel instance = new ErrorLevel();
	private ErrorLevel() {};
	
	public static ErrorLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lowerOrEquals(ErrorLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "ERROR";
	}

}
