package ar.fiuba.tecnicas.logging;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.config.ILogConfiguration;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.ILevel;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.OutputFactory;
import ar.fiuba.tecnicas.logging.log.ILog;
import ar.fiuba.tecnicas.logging.log.IOutput;

public class LoggerFactoryDefault implements LoggerFactoryHandler{
	private LoggerFactoryHandler next;
	
	public static LoggerFactoryDefault factory=new LoggerFactoryDefault();
	public static LoggerFactoryDefault getInstance(){
		return LoggerFactoryDefault.factory;
	}
	public LoggerFactoryHandler getNext(){
		return next;
	}
	public void setNext(LoggerFactoryHandler handler){
		this.next=handler;
	}
	public ILogger createLogger(String loggerName){
		this.setNext(null);
		Logger logger = new Logger(loggerName);
		
		ILevel level = new Level(LevelPriority.values()[0]);
		logger.setMinLoggingLevel(level);
		ILogConfiguration logConfig = new LogConfiguration("%d{HH:mm:ss}-%p-%t-%m", 
				"ar.fiuba.tecnicas.logging.log.ConsoleOutput:", ";");
		IOutput output=OutputFactory.getInstance().makeOutputForOutputString("ar.fiuba.tecnicas.logging.log.ConsoleOutput:");
		ILog log = new Log(logConfig, output);
		
		logger.addLog(log);
		return logger;
	}
	
	public void setPropertiesPath(String path){
		
	}
}
