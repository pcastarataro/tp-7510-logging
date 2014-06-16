package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class LoggerNameFormatterTest extends TestCase {
	
private String loggerName;
	
	private ILogParameter logParameters;
	private LoggerNameFormatter formatter;
	
	@Override
	protected void setUp() {
		loggerName = "loggerName1";
		
		logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("loggerName")).thenReturn(loggerName);
		
		formatter = new LoggerNameFormatter();
	}
	
	@Override
	protected void tearDown() {
		loggerName = null;
		formatter = null;
		logParameters = null;
	}
	
	public void testLoggerNameFormatterWithOneValidPattern() {
		String baseFormat = "%g";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, loggerName);
	}
	
	
	public void testLoggerNameFormatterWithMultipleValidPattern() {
		String baseFormat = "%g - %g";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, loggerName + " - " + loggerName);
	}
	
	
	public void testLoggerNameFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
