package ar.fiuba.tecnicas.logging.level;

public class DebugLevel implements Level {

	private static DebugLevel instance = new DebugLevel();
	private DebugLevel() {};
	
	public static DebugLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lower(DebugLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "DEBUG";
	}

}
