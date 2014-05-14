package ar.fiuba.tecnicas.logging.level;

public class WarnLevel implements Level {

	private static WarnLevel instance = new WarnLevel();
	private WarnLevel() {};
	
	public static WarnLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lowerOrEquals(WarnLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "WARN";
	}

}
