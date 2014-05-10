package ar.fiuba.tecnicas.logging.level;

public class WarnLevel implements Level {

	private static WarnLevel instance = new WarnLevel();
	private WarnLevel() {};
	
	public static WarnLevel getInstance() {
		return instance;
	}
	
	public boolean isLowerThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lower(WarnLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "WARN";
	}

}
