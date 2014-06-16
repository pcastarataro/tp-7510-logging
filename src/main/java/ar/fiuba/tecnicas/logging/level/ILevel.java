package ar.fiuba.tecnicas.logging.level;

/**
 * This interface is used to abstract all the level information.
 * @author pablo
 *
 */
public interface ILevel {
	/**
	 * 
	 * @return the Level Name
	 */
	public String getName();
	
	/**
	 * This method compare 2 levels
	 * @param loggingLevel
	 * @return true if this is lower or equals than loggingLevel.
	 */
	public boolean isLowerOrEqualsThan(ILevel loggingLevel);
	
	/**
	 * 
	 * @return the Priority assigned the Level
	 */
	public LevelPriority getLevelPriority();
	
}
