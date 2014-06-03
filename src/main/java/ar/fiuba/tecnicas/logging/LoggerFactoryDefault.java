package ar.fiuba.tecnicas.logging;

import ar.fiuba.tecnicas.logging.config.ConcreteLogConfiguration;
import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ConcreteLog;
import ar.fiuba.tecnicas.logging.log.ConcreteOutputFactory;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.Output;

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
	public Logger createLogger(String loggerName){
		this.setNext(null);
		ConcreteLogger logger = new ConcreteLogger(loggerName);
		
		Level level = new ConcreteLevel(LevelPriority.values()[0]);
		logger.setMinLoggingLevel(level);
		LogConfiguration logConfig = new ConcreteLogConfiguration("%d{HH:mm:ss}-%p-%t-%m", 
				"ar.fiuba.tecnicas.logging.log.ConsoleOutput:", ";");
		Output output=ConcreteOutputFactory.getInstance().makeOutputForOutputString("ar.fiuba.tecnicas.logging.log.ConsoleOutput:");
		Log log = new ConcreteLog(logConfig, output);
		
		logger.addLog(log);
		return logger;
	}
}
