package ar.fiuba.tecnicas.logging.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogOutput implements LogOutput {

	String fileName;
	
	public FileLogOutput(String fileName){
		this.fileName = fileName;
	}
	
	public void doPrint(String message){
		
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    PrintWriter file = new PrintWriter(bufferedWriter);
		    file.println(message);
		    file.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
