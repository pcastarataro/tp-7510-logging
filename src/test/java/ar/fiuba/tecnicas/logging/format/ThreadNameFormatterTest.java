package ar.fiuba.tecnicas.logging.format;

import junit.framework.TestCase;

import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;

public class ThreadNameFormatterTest extends TestCase {

	private String threadName;
	
	private IExecutionContext executionContext;
	private ILogParameter logParameters;
	private ThreadNameFormatter formatter;
	
	@Override
	protected void setUp() {
		threadName = "main-thread";
		executionContext = Mockito.mock(IExecutionContext.class);
		when(executionContext.getThreadName()).thenReturn(threadName);
		
		logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("executionContext")).thenReturn(executionContext);
		
		formatter = new ThreadNameFormatter();
	}
	
	@Override
	protected void tearDown() {
		threadName = null;
		executionContext = null;
		formatter = null;
		logParameters = null;
	}
	
	
	public void testThreadNameFormatterWithOneValidPattern() {
		String baseFormat = "%t";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, threadName);
	}
	
	
	public void testThreadNameFormatterWithMultipleValidPattern() {
		String baseFormat = "%t - %t";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, threadName + " - " + threadName);
	}
	
	
	public void testThreadNameFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}
	
}
