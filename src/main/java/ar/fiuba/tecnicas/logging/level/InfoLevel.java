package ar.fiuba.tecnicas.logging.level;

public class InfoLevel implements Level {

	private static InfoLevel instance = new InfoLevel();
	private InfoLevel() {};
	
	public static InfoLevel getInstance() {
		return instance;
	}
		
	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lowerOrEquals(InfoLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "INFO";
	}

}
