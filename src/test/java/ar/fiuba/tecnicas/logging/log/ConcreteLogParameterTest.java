package ar.fiuba.tecnicas.logging.log;


import java.util.Date;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.format.ConcreteLogParameter;
import ar.fiuba.tecnicas.logging.format.ParameterNotFoundException;
import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import junit.framework.TestCase;

public class ConcreteLogParameterTest extends TestCase {
	
	
	private Date date = new Date();
	private String message = "message";
	private String delimiter = "/";
	private String loggerName = "/";
	private ExecutionContext executionContext = new LoggingExecutionContext();
	private Level level = new ConcreteLevel(LevelPriority.DEBUG);
	
	private ConcreteLogParameter logParameters = new ConcreteLogParameter(level, 
			message, 
			executionContext, 
			delimiter, 
			date, 
			loggerName);
	
	public void testGetLevel() {
		assertEquals(level, logParameters.getParameterNamed("level"));
	}
	
	public void testGetName() {
		assertEquals(loggerName, logParameters.getParameterNamed("loggerName"));
	}
	
	public void testGetMessage() {
		assertEquals(message, logParameters.getParameterNamed("message"));
	}

	public void testGetExecutionContext() {
		assertEquals(executionContext, logParameters.getParameterNamed("executionContext"));
	}
	
	public void testGetDelimiter() {
		assertEquals(delimiter, logParameters.getParameterNamed("delimiter"));
	}
	
	public void testGetDate() {
		assertEquals(date, logParameters.getParameterNamed("date"));
	}
	
	public void testInvalidParameter() {
		try {
			logParameters.getParameterNamed("somethingWrong");
			fail();
		}
		catch(ParameterNotFoundException ex) {
			assertTrue(true);
		}
	}
}
