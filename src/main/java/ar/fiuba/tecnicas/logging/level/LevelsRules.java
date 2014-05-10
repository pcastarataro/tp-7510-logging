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
		this.addLowerLevelsForLevelClass(this.getLowersLevelsForOffLevel(), OffLevel.class);
		this.addLowerLevelsForLevelClass(this.getLowersLevelsForFatalLevel(), FatalLevel.class);
		this.addLowerLevelsForLevelClass(this.getLowersLevelsForErrorLevel(), ErrorLevel.class);
		this.addLowerLevelsForLevelClass(this.getLowersLevelsForWarnLevel(), WarnLevel.class);
		this.addLowerLevelsForLevelClass(this.getLowersLevelsForInfoLevel(), InfoLevel.class);
		this.addLowerLevelsForLevelClass(this.getLowersLevelsForDebugLevel(), DebugLevel.class);
	}
	
	private List<Level> getLowersLevelsForOffLevel() {
		List<Level> rules = new ArrayList<Level>();
		return rules;
	}
	
	private List<Level> getLowersLevelsForFatalLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersLevelsForErrorLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersLevelsForWarnLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersLevelsForInfoLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		rules.add(WarnLevel.getInstance());
		return rules;
	}
	
	private List<Level> getLowersLevelsForDebugLevel() {
		List<Level> rules = new ArrayList<Level>();
		rules.add(OffLevel.getInstance());
		rules.add(FatalLevel.getInstance());
		rules.add(ErrorLevel.getInstance());
		rules.add(WarnLevel.getInstance());
		rules.add(InfoLevel.getInstance());
		return rules;
	}
	
	private void addLowerLevelsForLevelClass(List<Level> levels, Class<?> levelClass) {
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
	public Level lower(Class<?> levelClass, Level firstLevel, Level secondLevel) {
		return lowerLevelsByClass.get(levelClass).contains(secondLevel)? secondLevel: firstLevel;
	}

}
