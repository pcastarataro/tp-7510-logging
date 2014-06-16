package ar.fiuba.tecnicas.logging.log;


import java.util.Date;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.format.LogParameter;
import ar.fiuba.tecnicas.logging.format.ParameterNotFoundException;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.ILevel;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import junit.framework.TestCase;

public class ConcreteLogParameterTest extends TestCase {
	
	
	private Date date = new Date();
	private String message = "message";
	private String delimiter = "/";
	private String loggerName = "/";
	private IExecutionContext executionContext = new LoggingExecutionContext();
	private ILevel level = new Level(LevelPriority.DEBUG);
	
	private LogParameter logParameters = new LogParameter(level, 
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
