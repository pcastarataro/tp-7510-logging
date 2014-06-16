package ar.fiuba.tecnicas.logging.log;

import junit.framework.TestCase;

public class OutputFactoryTest extends TestCase {

	IOutputFactory factory = new OutputFactory();
	
	public void testFactoryFileOutputOk(){
		String filePattern = FileOutput.class.getName() + ":Hola.txt";
		IOutput output = factory.makeOutputForOutputString(filePattern);
		
		assertEquals(output.getClass().getName(), FileOutput.class.getName());
	}
	
	public void testFactoryFileOutputError(){
		try{
			String filePattern = "file1:";
			IOutput output = factory.makeOutputForOutputString(filePattern);
			assertTrue(output != null);
		}
		catch (IllegalOutputPatternException ex) {
			assertTrue(true);
		}
	}
	
	public void testFactoryConsoleOutputOk(){
		String consolePattern = ConsoleOutput.class.getName() + ":";
		IOutput output = factory.makeOutputForOutputString(consolePattern);
		
		assertEquals(output.getClass().getName(), ConsoleOutput.class.getName());
	}
	
	public void testFactoryConsoleOutputError(){

		try{
			String consolePattern = "console111:";
			IOutput output = factory.makeOutputForOutputString(consolePattern);
			assertTrue(output != null);
		}
		catch (IllegalOutputPatternException ex) {
			assertTrue(true);
		}
	}
}
