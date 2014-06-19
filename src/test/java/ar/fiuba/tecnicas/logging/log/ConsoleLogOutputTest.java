
package ar.fiuba.tecnicas.logging.log;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class ConsoleLogOutputTest extends TestCase{
	public void testConsoleLogOutputDoPrint(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream origOut=System.out;
		System.setOut(new PrintStream(baos,true));
		ConsoleOutput consoleLogOutput=new ConsoleOutput();
		String mensaje="%%Main.java main : 14 : main HOLAAA Main.java : probando otro mensaje : %  FATAL 2014 5 2014-05";
		consoleLogOutput.doPrint(mensaje);
		assertEquals(baos.toString().replaceAll("\r", "").replaceAll("\n", ""),mensaje);
		System.setOut(origOut);
	} 
	public void testConsoleLogOutputGetAsXml(){
		String xmlWanted="<outputstring>ar.fiuba.tecnicas.logging.log.ConsoleOutput:</outputstring>";
		IOutput output=OutputFactory.getInstance().makeOutputForOutputString(ConsoleOutput.class.getName() + ":");
		String xmlCreatedOutput=output.getAsXml();
        assertEquals(xmlWanted,xmlCreatedOutput);
	}
}
