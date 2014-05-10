package ar.fiuba.tecnicas.logging.level;

/**
 * This interface is used to abstract all the level information.
 * @author pablo
 *
 */
public interface Level {
	/**
	 * 
	 * @return the Level Name
	 */
	public String getName();
	
	/**
	 * This method compare 2 levels
	 * @param loggingLevel
	 * @return true if this is lower than loggingLevel.
	 */
	public boolean isLowerThan(Level loggingLevel);
	
}
