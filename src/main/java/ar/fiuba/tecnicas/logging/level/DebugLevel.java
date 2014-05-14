package ar.fiuba.tecnicas.logging.level;

public class DebugLevel implements Level {

	private static DebugLevel instance = new DebugLevel();
	private DebugLevel() {};
	
	public static DebugLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lowerOrEquals(DebugLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "DEBUG";
	}

}
