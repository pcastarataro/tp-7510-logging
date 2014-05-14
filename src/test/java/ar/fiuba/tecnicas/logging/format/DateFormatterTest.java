package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

import ar.fiuba.tecnicas.logging.format.DateFormatter;

public class DateFormatterTest extends TestCase {

	private LogParameter logParameters;
	private DateFormatter dateFormatter;
	
	@Override
	protected void setUp() {
		try {
			dateFormatter = new DateFormatter();
			
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2000-03-30 21:00:00");
			
			logParameters = Mockito.mock(LogParameter.class);
			when(logParameters.getParameterNamed("date")).thenReturn(date);
			
		} catch (ParseException e) {}		
	}
	
	@Override
	protected void tearDown() {
		logParameters = null;
		dateFormatter = null;
	}
		
	@Test
	public void testFormatDateWithValidFormat() {
		try {
			String baseFormat = "%d{yyyy-MM}";
			baseFormat = dateFormatter.preProcessFormat(baseFormat, logParameters);
			baseFormat = dateFormatter.postProcessFormat(baseFormat, logParameters);
			assertEquals(baseFormat, "2000-03");
		} catch (IlegalDatePattern e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testFormatMultiplesDatesWithValidFormats() {
		try {
			String baseFormat = "%d{yyyy-MM} %d{dd} %d{yyyy-MM}";
			baseFormat = dateFormatter.preProcessFormat(baseFormat, logParameters);
			baseFormat = dateFormatter.postProcessFormat(baseFormat, logParameters);
			assertEquals(baseFormat, "2000-03 30 2000-03");
		} catch (IlegalDatePattern e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testFormatDateWithInvalidFormat() {
		try {
			String baseFormat = "%d{HelloWorld!}";
			baseFormat = dateFormatter.preProcessFormat(baseFormat, logParameters);
			baseFormat = dateFormatter.postProcessFormat(baseFormat, logParameters);
			assertFalse(true);
		} 
		catch (IlegalDatePattern iE) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testFormatDateWithNoFormat() {
		try {
			String emptyString = "";
			String baseFormat = "%d{}";
			baseFormat = dateFormatter.preProcessFormat(baseFormat, logParameters);
			baseFormat = dateFormatter.postProcessFormat(baseFormat, logParameters);
			assertEquals(baseFormat, emptyString);
		} 
		catch (IlegalDatePattern iE) {
			assertTrue(false);
		}
	}
	
}
