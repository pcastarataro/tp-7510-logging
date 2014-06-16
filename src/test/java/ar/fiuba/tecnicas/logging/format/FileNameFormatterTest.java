package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import junit.framework.TestCase;

public class FileNameFormatterTest extends TestCase {

	private String fileName;
	
	private IExecutionContext executionContext;
	private ILogParameter logParameters;
	private FileNameFormatter formatter;
	
	@Override
	protected void setUp() {
		fileName = "file.java";
		executionContext = Mockito.mock(IExecutionContext.class);
		when(executionContext.getFileName()).thenReturn(fileName);
		
		logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("executionContext")).thenReturn(executionContext);
		
		formatter = new FileNameFormatter();
	}
	
	@Override
	protected void tearDown() {
		fileName = null;
		executionContext = null;
		formatter = null;
		logParameters = null;
	}
	
	
	public void testThreadNameFormatterWithOneValidPattern() {
		String baseFormat = "%F";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, fileName);
	}
	
	
	public void testThreadNameFormatterWithMultipleValidPattern() {
		String baseFormat = "%F - %F";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, fileName + " - " + fileName);
	}
	
	
	public void testThreadNameFormatterWithNoValidPattern() {
		String baseFormat = "Hello World";
		baseFormat = formatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = formatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
