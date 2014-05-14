package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;

public class LineNumberFormatterTest extends TestCase {
	
	private int lineNumber;
	
	private ExecutionContext executionContext;
	private LogParameter logParameters;
	private LineNumberFormatter formatter;
	
	@Override
	protected void setUp() {
		lineNumber = 14;
		executionContext = Mockito.mock(ExecutionContext.class);
		when(executionContext.getLineNumber()).thenReturn(lineNumber);
		
		logParameters = Mockito.mock(LogParameter.class);
		when(logParameters.getParameterNamed("executionContext")).thenReturn(executionContext);
		
		formatter = new LineNumberFormatter();
	}
	
	@Override
	protected void tearDown() {
		lineNumber = 0;
		executionContext = null;
		formatter = null;
		logParameters = null;
	}
	
	@Test
	public void testLineNumberFormatterWithOneValidPattern() {
		String baseFormat = "%L";
		baseFormat = applyFormat(baseFormat);
		assertEquals(baseFormat, String.valueOf(lineNumber));
	}
	
	@Test
	public void testLineNumberFormatterWithMultipleValidPattern() {
		String baseFormat = "%L - %L";
		baseFormat = applyFormat(baseFormat);
		assertEquals(baseFormat, String.valueOf(lineNumber) + " - " + String.valueOf(lineNumber));
	}
	
	@Test
	public void testLineNumberFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = applyFormat(baseFormat);
		assertEquals(baseFormat, baseFormat);
	}

	private String applyFormat(String baseFormat) {
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		return baseFormat;
	}

}
