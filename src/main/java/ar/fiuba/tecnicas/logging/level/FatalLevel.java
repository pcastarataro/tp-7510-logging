package ar.fiuba.tecnicas.logging.level;

public class FatalLevel implements Level {
	
	private static FatalLevel instance = new FatalLevel();
	private FatalLevel() {};
	
	public static FatalLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lower(FatalLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "FATAL";
	}

}
