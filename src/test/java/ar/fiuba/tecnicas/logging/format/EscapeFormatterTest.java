package ar.fiuba.tecnicas.logging.format;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class EscapeFormatterTest extends TestCase {

	private EscapeFormatter escapeFormatter;
	LogParameter logParameters;

	@Override
	protected void setUp() {
		escapeFormatter = new EscapeFormatter();
		logParameters = Mockito.mock(LogParameter.class);
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
		LogParameter logParameters = Mockito.mock(LogParameter.class);

		String baseFormat = "Hello World";
		baseFormat = escapeFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = escapeFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
