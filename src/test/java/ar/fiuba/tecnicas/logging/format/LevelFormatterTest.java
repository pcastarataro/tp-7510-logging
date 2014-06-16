package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import ar.fiuba.tecnicas.logging.level.ILevel;
import junit.framework.TestCase;

public class LevelFormatterTest extends TestCase {
	
	private String levelName;
	
	private ILevel level;
	private ILogParameter logParameters;
	private LevelFormatter formatter;
	
	@Override
	protected void setUp() {
		levelName = "DEBUG";
		
		level = Mockito.mock(ILevel.class);
		when(level.getName()).thenReturn(levelName);
		
		logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("level")).thenReturn(level);
		
		formatter = new LevelFormatter();
	}
	
	@Override
	protected void tearDown() {
		levelName = null;
		formatter = null;
		logParameters = null;
	}
	
	
	public void testMessageFormatterWithOneValidPattern() {
		String baseFormat = "%p";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, levelName);
	}
	
	
	public void testMessageFormatterWithMultipleValidPattern() {
		String baseFormat = "%p - %p";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, levelName + " - " + levelName);
	}
	
	
	public void testMessageFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}
}
