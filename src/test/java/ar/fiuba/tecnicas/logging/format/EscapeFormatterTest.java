package ar.fiuba.tecnicas.logging.format;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class EscapeFormatterTest extends TestCase {

	private EscapeFormatter escapeFormatter;
	ILogParameter logParameters;

	@Override
	protected void setUp() {
		escapeFormatter = new EscapeFormatter();
		logParameters = Mockito.mock(ILogParameter.class);
	}

	@Override
	protected void tearDown() {
		escapeFormatter = null;
	}
	
	
	public void testSimpleDelimiterFormat() {
		String baseFormat = "%%";
		baseFormat = escapeFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = escapeFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, "%");
	}
	
	
	public void testMultipleEscaped() {
		String expectedResult = "%%";
		
		String baseFormat = "%%%%";
		baseFormat = escapeFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = escapeFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, expectedResult);

	}
	
	
	public void testNoChangeWhenNoFormat() {
		ILogParameter logParameters = Mockito.mock(ILogParameter.class);

		String baseFormat = "Hello World";
		baseFormat = escapeFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = escapeFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
