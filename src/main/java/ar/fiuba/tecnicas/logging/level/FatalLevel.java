package ar.fiuba.tecnicas.logging.level;

public class FatalLevel implements Level {
	
	private static FatalLevel instance = new FatalLevel();
	private FatalLevel() {};
	
	public static FatalLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lowerOrEquals(FatalLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "FATAL";
	}

}
