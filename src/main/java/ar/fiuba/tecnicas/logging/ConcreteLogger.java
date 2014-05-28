package ar.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.MinLevelIsLowerException;


/**
 * Implementation of a specific main logger class of the logging system. 
 *
 */
public class ConcreteLogger implements Logger{
	
	private List<Log> logs;
	
	public ConcreteLogger() {
		logs = new ArrayList<Log>();
	}
	
	public void addLog(Log log) {
		logs.add(log);
	}
	

	public void log(LevelPriority loggingLevel, String message) {
		Level level = new ConcreteLevel(loggingLevel);
		for (Log log : logs) {
			doLog(log, level, message);
		}
	}
	
	private void doLog(Log log, Level loggingLevel, String message) {
		try {
			log.log(loggingLevel, message);	
		}
		catch(MinLevelIsLowerException ex) {
			System.err.println("Min Level: " + log.getLogConfiguration().getMinLoggingLevel().getName() +
					" - " + "Level: " + loggingLevel.getName() + " - " + message);
		}
	}
	
	public String getXmlConfig(){
		String xmlConfig="<logger>";
		int cantLogs=this.logs.size();
		for(int i=0;i<cantLogs;i++){
			xmlConfig+=this.logs.get(i).getLogConfiguration().getAsXml();
		}
		xmlConfig+="</logger>";
		return xmlConfig;
	}
}
