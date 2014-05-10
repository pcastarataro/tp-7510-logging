package ar.fiuba.tecnicas.logging.level;

public class InfoLevel implements Level {

	private static InfoLevel instance = new InfoLevel();
	private InfoLevel() {};
	
	public static InfoLevel getInstance() {
		return instance;
	}
		
	public boolean isLowerThan(Level loggingLevel) {
		return (LevelsRules.getInstance().lower(InfoLevel.class, this, loggingLevel) == this);
	}

	public String getName() {
		return "INFO";
	}

}
