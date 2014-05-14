package ar.fiuba.tecnicas.logging.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class has the responsability of manage all the rules associated with all the levels of logging.
 * This class only may change when the rules have to be modified or a new Level is has to be added.
 * @author pablo
 *
 */
public class LevelsRules {

	private static LevelsRules rule = new LevelsRules();
	private Map<Class<?>, List<Level>> lowerLevelsByClass = new HashMap<Class<?>, List<Level>>();

	private LevelsRules() {
		this.initializeRules();
	}

	private void initializeRules() {
		this.addLowerOrEqualsLevelsForLevelClass(this.getLowersOrEqualsLevelsForOffLevel(), OffLevel.class);
		this.addLowerOrEqualsLevelsForLevelClass(this.getLowersOrEqualsLevelsForFatalLevel(), FatalLevel.class);
		this.addLowerOrEqualsLevelsForLevelClass(this.getLowersOrEqualsLevelsForErrorLevel(), ErrorLevel.class);
		this.addLowerOrEqualsLevelsForLevelClass(this.getLowersOrEqualsLevelsForWarnLevel(), WarnLevel.class);
		this.addLowerOrEqualsLevelsForLevelClass(this.getLowersOrEqualsLevelsForInfoLevel(), InfoLevel.class);
		this.addLowerOrEqualsLevelsForLevelClass(this.getLowersOrEqualsLevelsForDebugLevel(), DebugLevel.class);
	}
	
	private List<Level> getLowersOrEqualsLevelsForOffLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersOrEqualsLevelsForFatalLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersOrEqualsLevelsForErrorLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersOrEqualsLevelsForWarnLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		rules.add(WarnLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersOrEqualsLevelsForInfoLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		rules.add(WarnLevel.getInstance());
		rules.add(InfoLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersOrEqualsLevelsForDebugLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		rules.add(WarnLevel.getInstance());
		rules.add(InfoLevel.getInstance());
		rules.add(DebugLevel.getInstance());
		return rules;
	}
	
	private void addLowerOrEqualsLevelsForLevelClass(List<Level> levels, Class<?> levelClass) {
		lowerLevelsByClass.put(levelClass, levels);
	}
	
	/**
	 * 
	 * @return LevelsRule is the unique LevelsRule instance.
	 */
	public static LevelsRules getInstance() {
		return rule;
	}

	/**
	 * This function decide which level is the lower.
	 * @param levelClass is the class of the level to lookup for valid moves.
	 * @param firstLevel
	 * @param secondLevel
	 * @return Level. The level which wins between firstLevel and secondLevel.
	 */
	public Level lowerOrEquals(Class<?> levelClass, Level firstLevel, Level secondLevel) {
		return lowerLevelsByClass.get(levelClass).contains(secondLevel)? secondLevel: firstLevel;
	}

}
