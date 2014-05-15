
package ar.fiuba.tecnicas.logging.log;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class ConsoleLogOutputTest extends TestCase{
	public void testConsoleLogOutputDoPrint(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream origOut=System.out;
		System.setOut(new PrintStream(baos,true));
		ConsoleLogOutput consoleLogOutput=new ConsoleLogOutput();
		String mensaje="%%Main.java main : 14 : main HOLAAA Main.java : probando otro mensaje : %  FATAL 2014 5 2014-05";
		consoleLogOutput.doPrint(mensaje);
		assertEquals(baos.toString().replaceAll("\r", "").replaceAll("\n", ""),mensaje);
		System.setOut(origOut);
	}  
}
