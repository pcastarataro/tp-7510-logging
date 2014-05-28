package ar.fiuba.tecnicas.logging.log;

import junit.framework.TestCase;

public class OutputFactoryTest extends TestCase {

	OutputFactory factory = new ConcreteOutputFactory();
	
	public void testFactoryFileOutputOk(){
		String filePattern = "file:Hola.txt";
		Output output = factory.makeOutputForOutputString(filePattern);
		
		assertEquals(output.getClass().getName(), FileOutput.class.getName());
	}
	
	public void testFactoryFileOutputError(){
		try{
			String filePattern = "file1:";
			Output output = factory.makeOutputForOutputString(filePattern);
			assertTrue(output != null);
		}
		catch (IllegalOutputPatternException ex) {
			assertTrue(true);
		}
	}
	
	public void testFactoryConsoleOutputOk(){
		String consolePattern = "console:";
		Output output = factory.makeOutputForOutputString(consolePattern);
		
		assertEquals(output.getClass().getName(), ConsoleOutput.class.getName());
	}
	
	public void testFactoryConsoleOutputError(){

		try{
			String consolePattern = "console111:";
			Output output = factory.makeOutputForOutputString(consolePattern);
			assertTrue(output != null);
		}
		catch (IllegalOutputPatternException ex) {
			assertTrue(true);
		}
	}
}
