package ar.fiuba.tecnicas.logging.level;

public class OffLevel implements Level {
	
	private static OffLevel instance = new OffLevel();
	private OffLevel() {};
	
	public static OffLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lower(OffLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "OFF";
	}

}
