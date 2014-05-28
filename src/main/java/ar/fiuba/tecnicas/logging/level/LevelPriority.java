package ar.fiuba.tecnicas.logging.level;

/**
 * This enum contains all the Levels order by their priorities.
 * If you wan to add a new one, you must understand than they are 
 * ordered by their importance.
 *
 */
public enum LevelPriority {
	DEBUG,
	INFO,
	WARN,
	ERROR,
	FATAL,
	OFF
}
