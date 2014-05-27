package ar.fiuba.tecnicas.logging.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import junit.framework.TestCase;

public class FileLogOutputTest extends TestCase{
	public void testFileLogOutputDoPrintCreateFile(){
		String path="testFileLogOutPut.txt";
		File file = new File(path);
		file.delete();
		FileLogOutput fileLogOutput=new FileLogOutput(path);
		String mensaje="%%Main.java main : 14 : main HOLAAA Main.java : probando otro mensaje : %  FATAL 2014 5 2014-05";
		fileLogOutput.doPrint(mensaje);
		boolean seCreoArchivo=true;
		try {
			FileReader fileReader=new FileReader(path);
			fileReader.close();
			file = new File(path);
			file.delete();
		} catch (Exception e) {
			
			e.printStackTrace();
			seCreoArchivo=false;
		}
		assertEquals(seCreoArchivo,true);
	}
	
	public void testFileLogOutputDoPrintDoPrint(){
		String path="testFileLogOutPut.txt";
		File file = new File(path);
		file.delete();
		FileLogOutput fileLogOutput=new FileLogOutput(path);
		String mensaje="%%Main.java main : 14 : main HOLAAA Main.java : probando otro mensaje : %  FATAL 2014 5 2014-05";
		fileLogOutput.doPrint(mensaje);
		String leido="";
		try {
			FileReader fileReader=new FileReader(path);
			BufferedReader buffReader=new BufferedReader(fileReader);
			leido=buffReader.readLine();
			buffReader.close();
			file = new File(path);
			file.delete();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		assertEquals(leido,mensaje);
	}
}
