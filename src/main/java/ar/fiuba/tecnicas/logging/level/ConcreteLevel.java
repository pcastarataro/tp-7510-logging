package ar.fiuba.tecnicas.logging.level;

public class ConcreteLevel implements Level {

	private LevelPriority levelPriority;
	
	public ConcreteLevel(LevelPriority levelPriority){
		this.levelPriority = levelPriority;
	}
	
	public String getName() {
		return this.levelPriority.name();
	}

	public boolean isLowerOrEqualsThan(Level loggingLevel) {
		return levelPriority.compareTo(loggingLevel.getLevelPriority()) >= 0;
	}
	
	public LevelPriority getLevelPriority() {
		return this.levelPriority;
	}

}
