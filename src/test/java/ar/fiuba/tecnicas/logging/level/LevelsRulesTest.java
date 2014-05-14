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
		assertTrue(offLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanErrorLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanWarnLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanInfoLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	@Test
	public void testOffLevelIsLowerThanDebugLevel() {
		assertTrue(offLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	@Test
	public void testFatalLevelIsntLowerThanOffLevel() {
		assertFalse(fatalLevel.isLowerOrEqualsThan(offLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanErrorLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanWarnLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanInfoLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	@Test
	public void testFatalLevelIsLowerThanDebugLevel() {
		assertTrue(fatalLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	@Test
	public void testErrorLevelIsntLowerThanOffLevel() {
		assertFalse(errorLevel.isLowerOrEqualsThan(offLevel));
	}
	
	@Test
	public void testErrorLevelIsntLowerThanFatalLevel() {
		assertFalse(errorLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	@Test
	public void testErrorLevelIsLowerThanWarnLevel() {
		assertTrue(errorLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	@Test
	public void testErrorLevelIsLowerThanInfoLevel() {
		assertTrue(errorLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	@Test
	public void testErrorLevelIsLowerThanDebugLevel() {
		assertTrue(errorLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	@Test
	public void testWarnLevelIsntLowerThanOffLevel() {
		assertFalse(warnLevel.isLowerOrEqualsThan(offLevel));
	}
	
	@Test
	public void testWarnLevelIsntLowerThanFatalLevel() {
		assertFalse(warnLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	@Test
	public void testWarnLevelIsntLowerThanErrorLevel() {
		assertFalse(warnLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	@Test
	public void testWarnLevelIsLowerThanInfoLevel() {
		assertTrue(warnLevel.isLowerOrEqualsThan(infoLevel));
	}
	
	@Test
	public void testWarnLevelIsLowerThanDebugLevel() {
		assertTrue(warnLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanOffLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(offLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanFatalLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanErrorLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	@Test
	public void testInfoLevelIsntLowerThanWarnLevel() {
		assertFalse(infoLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	@Test
	public void testInfoLevelIsLowerThanDebugLevel() {
		assertTrue(infoLevel.isLowerOrEqualsThan(debugLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanOffLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(offLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanFatalLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(fatalLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanErrorLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(errorLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanWarnLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(warnLevel));
	}
	
	@Test
	public void testDebugLevelIsntLowerThanInfoLevel() {
		assertFalse(debugLevel.isLowerOrEqualsThan(infoLevel));
	}

}
