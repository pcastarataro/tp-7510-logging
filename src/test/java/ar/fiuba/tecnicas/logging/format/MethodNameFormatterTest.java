package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.mockito.Mockito;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;

public class MethodNameFormatterTest extends TestCase {
	
	private String methodName;
	
	private IExecutionContext executionContext;
	private ILogParameter logParameters;
	private MethodNameFormatter formatter;
	
	@Override
	protected void setUp() {
		methodName = "file.java";
		
		executionContext = Mockito.mock(IExecutionContext.class);
		when(executionContext.getMethodName()).thenReturn(methodName);
		
		logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("executionContext")).thenReturn(executionContext);
		
		formatter = new MethodNameFormatter();
	}
	
	@Override
	protected void tearDown() {
		methodName = null;
		executionContext = null;
		formatter = null;
		logParameters = null;
	}
	
	
	public void testThreadNameFormatterWithOneValidPattern() {
		String baseFormat = "%M";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, methodName);
	}
	
	
	public void testThreadNameFormatterWithMultipleValidPattern() {
		String baseFormat = "%M - %M";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, methodName + " - " + methodName);
	}
	
	
	public void testThreadNameFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
