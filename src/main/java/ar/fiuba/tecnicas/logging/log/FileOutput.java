package ar.fiuba.tecnicas.logging.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class implements the Output for print the messages in a file.
 *
 */
public class FileOutput implements Output {

	String fileName;
	
	/*
	 * (non-Javadoc)
	 * @see ar.fiuba.tecnicas.logging.log.Output#doPrint(java.lang.String)
	 */
	public void doPrint(String message) {
		
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
	
	/*
	 * (non-Javadoc)
	 * @see ar.fiuba.tecnicas.logging.log.Output#setOutputString(java.lang.String)
	 */
	public void setOutputString(String outputString)
			throws IllegalOutputPatternException {
		
		String fileOutputPattern = "file:";
		OutputProtocolValidator.validate(fileOutputPattern, outputString);
		
		int fileInitialPosition = fileOutputPattern.length();
		int fileFinalPosition = outputString.length();
	
		String fileName = outputString.substring(fileInitialPosition, 
				fileFinalPosition);
		this.fileName = fileName;

	}
}
