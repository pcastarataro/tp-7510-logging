package ar.fiuba.tecnicas.logging.level;

public class OffLevel implements Level {
	
	private static OffLevel instance = new OffLevel();
	private OffLevel() {};
	
	public static OffLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lowerOrEquals(OffLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "OFF";
	}

}
