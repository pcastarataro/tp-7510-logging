package ar.fiuba.tecnicas.logging.level;

import junit.framework.TestCase;

public class LevelsRulesTest extends TestCase {
	private Level offLevel = new ConcreteLevel(LevelPriority.OFF);
	private Level fatalLevel = new ConcreteLevel(LevelPriority.FATAL);
	private Level errorLevel = new ConcreteLevel(LevelPriority.ERROR);
	private Level warnLevel = new ConcreteLevel(LevelPriority.WARN);
	private Level infoLevel = new ConcreteLevel(LevelPriority.INFO);
	private Level debugLevel = new ConcreteLevel(LevelPriority.DEBUG);
	private Level traceLevel = new ConcreteLevel(LevelPriority.TRACE);
	
	
	public void testOffLevelIsLowerThanFatalLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	
	public void testOffLevelIsLowerThanErrorLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	
	public void testOffLevelIsLowerThanWarnLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	
	public void testOffLevelIsLowerThanInfoLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	
	public void testOffLevelIsLowerThanOffLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(offLevel));
	}
	
	
	public void testOffLevelIsLowerThanDebugLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	
	public void testFatalLevelIsntLowerThanOffLevel() {
		assertFalse(fatalLevel.isLowerOrEqualsThan(offLevel));
	}
	
	
	public void testFatalLevelIsLowerThanErrorLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	
	public void testFatalLevelIsLowerThanWarnLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	
	public void testFatalLevelIsLowerThanInfoLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	
	public void testFatalLevelIsLowerThanDebugLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	
	public void testErrorLevelIsntLowerThanOffLevel() {
		assertFalse(errorLevel.isLowerOrEqualsThan(offLevel));
	}
	
	
	public void testErrorLevelIsntLowerThanFatalLevel() {
		assertFalse(errorLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	
	public void testErrorLevelIsLowerThanWarnLevel() {
		assertTrue(errorLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	
	public void testErrorLevelIsLowerThanInfoLevel() {
		assertTrue(errorLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	
	public void testErrorLevelIsLowerThanDebugLevel() {
		assertTrue(errorLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	
	public void testWarnLevelIsntLowerThanOffLevel() {
		assertFalse(warnLevel.isLowerOrEqualsThan(offLevel));
	}
	
	
	public void testWarnLevelIsntLowerThanFatalLevel() {
		assertFalse(warnLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	
	public void testWarnLevelIsntLowerThanErrorLevel() {
		assertFalse(warnLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	
	public void testWarnLevelIsLowerThanInfoLevel() {
		assertTrue(warnLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	
	public void testWarnLevelIsLowerThanDebugLevel() {
		assertTrue(warnLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	
	public void testInfoLevelIsntLowerThanOffLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(offLevel));
	}
	
	
	public void testInfoLevelIsntLowerThanFatalLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	
	public void testInfoLevelIsntLowerThanErrorLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	
	public void testInfoLevelIsntLowerThanWarnLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	
	public void testInfoLevelIsLowerThanDebugLevel() {
		assertTrue(infoLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	
	public void testDebugLevelIsntLowerThanOffLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(offLevel));
	}
	
	
	public void testDebugLevelIsntLowerThanFatalLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	
	public void testDebugLevelIsntLowerThanErrorLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	
	public void testDebugLevelIsntLowerThanWarnLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	
	public void testDebugLevelIsntLowerThanInfoLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	public void testTraceLevelIsntLowerThanInfoLevel() {
		assertFalse(traceLevel.isLowerOrEqualsThan(infoLevel));
	}
		
	public void testTraceLevelIsntLowerThanWarnLevel() {
		assertFalse(traceLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	public void testTraceLevelIsntLowerThanErrorLevel() {
		assertFalse(traceLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	public void testTraceLevelIsntLowerThanFatalLevel() {
		assertFalse(traceLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	public void testTraceLevelIsntLowerThanOffLevel() {
		assertFalse(traceLevel.isLowerOrEqualsThan(offLevel));
	}
	
	public void testTraceLevelIsntLowerThanDebugLevel() {
		assertFalse(traceLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	public void testTraceLevelIsntLowerThanTraceLevel() {
		assertTrue(traceLevel.isLowerOrEqualsThan(traceLevel));
	}

}
