package ar.fiuba.tecnicas.logging.format;

import junit.framework.TestCase;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;


public class DelimiterFormatterTest extends TestCase {
	private DelimiterFormatter delimiterFormatter;

	@Override
	protected void setUp() {
		delimiterFormatter = new DelimiterFormatter();
	}

	@Override
	protected void tearDown() {
		delimiterFormatter = null;
	}

	private void testSimpleDelimiterFormatterWithDelimiter(String delimiter) {
		
		ILogParameter logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("delimiter")).thenReturn(delimiter);

		String baseFormat = "%n";
		baseFormat = delimiterFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = delimiterFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, delimiter);

	}
	
	
	public void testSimpleDelimiterFormat() {
		String delimiter = "-";
		testSimpleDelimiterFormatterWithDelimiter(delimiter);
	}
	
	
	public void testSimpleDelimiterFormatDiferentToDefault() {
		String delimiter = "$";
		testSimpleDelimiterFormatterWithDelimiter(delimiter);
	}
	
	
	public void testMultipleDelimiterFormat() {
		String delimiter = "-";
		
		ILogParameter logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("delimiter")).thenReturn(delimiter);


		String baseFormat = "%n%n";
		baseFormat = delimiterFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = delimiterFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, delimiter + delimiter);
	}
	
	
	public void testNoChangeWhenNoFormat() {
		String delimiter = "-";
		
		ILogParameter logParameters = Mockito.mock(ILogParameter.class);
		when(logParameters.getParameterNamed("delimiter")).thenReturn(delimiter);

		String baseFormat = "Hello World";
		baseFormat = delimiterFormatter.preProcessFormat(baseFormat, logParameters);
		baseFormat = delimiterFormatter.postProcessFormat(baseFormat, logParameters);
		assertEquals(baseFormat, baseFormat);
	}

}
