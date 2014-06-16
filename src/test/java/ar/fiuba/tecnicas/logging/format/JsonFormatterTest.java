package ar.fiuba.tecnicas.logging.format;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ar.fiuba.tecnicas.logging.level.ILevel;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class JsonFormatterTest extends TestCase {
	
	private ILogParameter logParameters;
	
	@Override
	protected void setUp() {
		try {
			logParameters = Mockito.mock(ILogParameter.class);
			
			String message = "Hello World!";
			String logger = "Logger";
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").parse("2000-03-30 21:00:00.000-0300");
			
			ILevel level = Mockito.mock(ILevel.class);
			when(level.getName()).thenReturn("DEBUG");
			
			when(logParameters.getParameterNamed("date")).thenReturn(date);			
			when(logParameters.getParameterNamed("message")).thenReturn(message);			
			when(logParameters.getParameterNamed("level")).thenReturn(level);
			when(logParameters.getParameterNamed("loggerName")).thenReturn(logger);
			
		} catch (ParseException e) {}
	}
	
	public void testJsonFormatter() {
		String jsonFormat = "%J";
		
		JsonFormatter formatter = new JsonFormatter();
		jsonFormat = formatter.preProcessFormat(jsonFormat, logParameters);
		jsonFormat = formatter.postProcessFormat(jsonFormat, logParameters);
		assertEquals("{'datetime':'2000-03-30T21:00:00.000-0300','level':'DEBUG','logger':'Logger','message':'Hello World!'}", jsonFormat);
	}
}
