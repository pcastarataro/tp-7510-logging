package ar.fiuba.tecnicas.logging.level;

/**
 * Implementation of a specific Level Class
 */
public class Level implements ILevel {

	private LevelPriority levelPriority;
	
	/**
	 * Creates a new Instance of ConcreteLevel with the priority send as parameter.
	 * @param levelPriority
	 */
	public Level(LevelPriority levelPriority){
		this.levelPriority = levelPriority;
	}
	
	/**
	 * Returns the Priority name
	 */
	public String getName() {
		return this.levelPriority.name();
	}

	/**
	 * Returns true if the Level is lower or equals than the level send as parameter. 
	 * False in other case 
	 */
	public boolean isLowerOrEqualsThan(ILevel loggingLevel) {
		return levelPriority.compareTo(loggingLevel.getLevelPriority()) >= 0;
	}
	
	/**
	 * Returns the priority associated to the Level.
	 */
	public LevelPriority getLevelPriority() {
		return this.levelPriority;
	}
}
