package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import ar.fiuba.tecnicas.logging.level.Level;
import junit.framework.TestCase;

public class LevelFormatterTest extends TestCase {
	
	private String levelName;
	
	private Level level;
	private LogParameter logParameters;
	private LevelFormatter formatter;
	
	@Override
	protected void setUp() {
		levelName = "DEBUG";
		
		level = Mockito.mock(Level.class);
		when(level.getName()).thenReturn(levelName);
		
		logParameters = Mockito.mock(LogParameter.class);
		when(logParameters.getParameterNamed("level")).thenReturn(level);
		
		formatter = new LevelFormatter();
	}
	
	@Override
	protected void tearDown() {
		levelName = null;
		formatter = null;
		logParameters = null;
	}
	
	@Test
	public void testMessageFormatterWithOneValidPattern() {
		String baseFormat = "%p";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, levelName);
	}
	
	@Test
	public void testMessageFormatterWithMultipleValidPattern() {
		String baseFormat = "%p - %p";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, levelName + " - " + levelName);
	}
	
	@Test
	public void testMessageFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}
}
