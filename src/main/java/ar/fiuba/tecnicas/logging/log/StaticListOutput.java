package ar.fiuba.tecnicas.logging.log;

import java.util.ArrayList;
import java.util.List;

public class StaticListOutput implements IOutput {

	public static List<String> messageList = new ArrayList<String>();
	
	public void doPrint(String message) {
		messageList.add(message);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ar.fiuba.tecnicas.logging.log.Output#setOutputString(java.lang.String)
	 */
	public void setOutputString(String outputString)
			throws IllegalOutputPatternException {
	}
	
	public String getAsXml(){
		return "<outputstring>"+this.getClass().getName()+":"+"</outputstring>";
	}
}
