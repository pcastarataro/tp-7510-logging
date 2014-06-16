package ar.fiuba.tecnicas.logging.level;

import junit.framework.TestCase;

public class LevelsRulesTest extends TestCase {
	private ILevel offLevel = new Level(LevelPriority.OFF);
	private ILevel fatalLevel = new Level(LevelPriority.FATAL);
	private ILevel errorLevel = new Level(LevelPriority.ERROR);
	private ILevel warnLevel = new Level(LevelPriority.WARN);
	private ILevel infoLevel = new Level(LevelPriority.INFO);
	private ILevel debugLevel = new Level(LevelPriority.DEBUG);
	private ILevel traceLevel = new Level(LevelPriority.TRACE);
	
	
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
	
	public void testNameOff() {
		assertEquals("OFF", offLevel.getName());
	}

	public void testNameFatal() {
		assertEquals("FATAL",fatalLevel.getName());
	}
	
	public void testNameError() {
		assertEquals("ERROR", errorLevel.getName());
	}
	
	public void testNameWarn() {
		assertEquals("WARN", warnLevel.getName());
	}
	
	public void testNameInfo() {
		assertEquals("INFO", infoLevel.getName());
	}
	
	public void testNameDebug() {
		assertEquals("DEBUG", debugLevel.getName());
	}
	
	public void testNameTrace() {
		assertEquals("TRACE", traceLevel.getName());
	}
}
