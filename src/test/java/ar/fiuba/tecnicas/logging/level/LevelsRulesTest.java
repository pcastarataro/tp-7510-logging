package ar.fiuba.tecnicas.logging.level;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LevelsRulesTest {
	private Level offLevel = OffLevel.getInstance();
	private Level fatalLevel = FatalLevel.getInstance();
	private Level errorLevel = ErrorLevel.getInstance();
	private Level warnLevel = WarnLevel.getInstance();
	private Level infoLevel = InfoLevel.getInstance();
	private Level debugLevel = DebugLevel.getInstance();
	
	@Test
	public void testOffLevelIsLowerThanFatalLevel() {
		assertTrue(offLevel.isLowerThan(fatalLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanErrorLevel() {
		assertTrue(offLevel.isLowerThan(errorLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanWarnLevel() {
		assertTrue(offLevel.isLowerThan(warnLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanInfoLevel() {
		assertTrue(offLevel.isLowerThan(infoLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanDebugLevel() {
		assertTrue(offLevel.isLowerThan(debugLevel));
	}
	
	@Test
	public void testFatalLevelIsntLowerThanOffLevel() {
		assertFalse(fatalLevel.isLowerThan(offLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanErrorLevel() {
		assertTrue(fatalLevel.isLowerThan(errorLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanWarnLevel() {
		assertTrue(fatalLevel.isLowerThan(warnLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanInfoLevel() {
		assertTrue(fatalLevel.isLowerThan(infoLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanDebugLevel() {
		assertTrue(fatalLevel.isLowerThan(debugLevel));
	}
	
	@Test
	public void testErrorLevelIsntLowerThanOffLevel() {
		assertFalse(errorLevel.isLowerThan(offLevel));
	}
	
	@Test
	public void testErrorLevelIsntLowerThanFatalLevel() {
		assertFalse(errorLevel.isLowerThan(fatalLevel));
	}
	
	@Test
	public void testErrorLevelIsLowerThanWarnLevel() {
		assertTrue(errorLevel.isLowerThan(warnLevel));
	}
	
	@Test
	public void testErrorLevelIsLowerThanInfoLevel() {
		assertTrue(errorLevel.isLowerThan(infoLevel));
	}
	
	@Test
	public void testErrorLevelIsLowerThanDebugLevel() {
		assertTrue(errorLevel.isLowerThan(debugLevel));
	}
	
	@Test
	public void testWarnLevelIsntLowerThanOffLevel() {
		assertFalse(warnLevel.isLowerThan(offLevel));
	}
	
	@Test
	public void testWarnLevelIsntLowerThanFatalLevel() {
		assertFalse(warnLevel.isLowerThan(fatalLevel));
	}
	
	@Test
	public void testWarnLevelIsntLowerThanErrorLevel() {
		assertFalse(warnLevel.isLowerThan(errorLevel));
	}
	
	@Test
	public void testWarnLevelIsLowerThanInfoLevel() {
		assertTrue(warnLevel.isLowerThan(infoLevel));
	}
	
	@Test
	public void testWarnLevelIsLowerThanDebugLevel() {
		assertTrue(warnLevel.isLowerThan(debugLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanOffLevel() {
		assertFalse(infoLevel.isLowerThan(offLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanFatalLevel() {
		assertFalse(infoLevel.isLowerThan(fatalLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanErrorLevel() {
		assertFalse(infoLevel.isLowerThan(errorLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanWarnLevel() {
		assertFalse(infoLevel.isLowerThan(warnLevel));
	}
	
	@Test
	public void testInfoLevelIsLowerThanDebugLevel() {
		assertTrue(infoLevel.isLowerThan(debugLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanOffLevel() {
		assertFalse(debugLevel.isLowerThan(offLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanFatalLevel() {
		assertFalse(debugLevel.isLowerThan(fatalLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanErrorLevel() {
		assertFalse(debugLevel.isLowerThan(errorLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanWarnLevel() {
		assertFalse(debugLevel.isLowerThan(warnLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanInfoLevel() {
		assertFalse(debugLevel.isLowerThan(infoLevel));
	}

}
