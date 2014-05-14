package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;


public class MessageFormatterTest extends TestCase {
	
	private String message;
	
	private LogParameter logParameters;
	private MessageFormatter formatter;
	
	@Override
	protected void setUp() {
		message = "Message 1234";
		
		logParameters = Mockito.mock(LogParameter.class);
		when(logParameters.getParameterNamed("message")).thenReturn(message);
		
		formatter = new MessageFormatter();
	}
	
	@Override
	protected void tearDown() {
		message = null;
		formatter = null;
		logParameters = null;
	}
	
	@Test
	public void testMessageFormatterWithOneValidPattern() {
		String baseFormat = "%m";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, message);
	}
	
	@Test
	public void testMessageFormatterWithMultipleValidPattern() {
		String baseFormat = "%m - %m";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, message + " - " + message);
	}
	
	@Test
	public void testMessageFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
