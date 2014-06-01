package ar.fiuba.tecnicas.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.w3c.dom.Element;

import ar.fiuba.tecnicas.logging.config.ConcreteLogConfiguration;
import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ConcreteLog;
import ar.fiuba.tecnicas.logging.log.ConcreteOutputFactory;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.Output;

public class LoggerFactoryFromPropertie implements LoggerFactoryHandler{
	private static LoggerFactoryFromPropertie factory=new LoggerFactoryFromPropertie();
	private Properties configProperties;
	private LoggerFactoryHandler next;
	private String path="logger-config.properties";
	
	public LoggerFactoryFromPropertie(){
		try {
			InputStream input = new FileInputStream(this.path);
			//System.out.println(input);
			this.configProperties=new Properties();
			this.configProperties.load(input);
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			this.configProperties=null;
		}
	}
	
	public static LoggerFactoryHandler getInstance(){
		return LoggerFactoryFromPropertie.factory;
	}
	
	public void setNext(LoggerFactoryHandler handler){
		this.next=handler;
	}
	
	public LoggerFactoryHandler getNext(){
		return this.next;
	}
	
	public boolean loggerExist(String loggerName){
		if(this.configProperties==null)return false;
		String loggers=this.configProperties.getProperty("loggers");
		String[] loggersNames=loggers.replaceAll(" ", "").split(",");
		for(int i=0;i<loggersNames.length;i++){
			if(loggersNames[i].equals(loggerName))return true;
		}
		return false;
	}
	
	private Level getLevelFromName(String name) {
		LevelPriority priority;
		try {
			priority = LevelPriority.valueOf(name.toUpperCase());
		}
		catch(RuntimeException e){
			priority = LevelPriority.values()[0];
		}
		return new ConcreteLevel(priority);
	}
	
	private Log createLog(String loggerName,String logName){
		String levelType = this.configProperties.getProperty(loggerName+"."+logName+".level");
		String baseFormat = this.configProperties.getProperty(loggerName+"."+logName+".baseformat");
		String filename = this.configProperties.getProperty(loggerName+"."+logName+".outputstring");
		String delimiter = this.configProperties.getProperty(loggerName+"."+logName+".delimiter");
		Level level = getLevelFromName(levelType);
		LogConfiguration logConfig = new ConcreteLogConfiguration(baseFormat, level, 
				filename, delimiter);
		Output output=ConcreteOutputFactory.getInstance().makeOutputForOutputString(filename);
		Log log = new ConcreteLog(logConfig,output);
		return log;	
	}
	
	private Logger createLoggerFromPropertie(String loggerName){
		ConcreteLogger logger = new ConcreteLogger(loggerName);
		String logs=this.configProperties.getProperty(loggerName+".logs");
		String[] logsNames=logs.replaceAll(" ", "").split(",");
		for(int i=0;i<logsNames.length;i++){
			Log log=this.createLog(loggerName,logsNames[i]);
			logger.addLog(log);
		}
		return logger;
	}
	
	public Logger createLogger(String loggerName){
		this.setNext(LoggerFactoryFromXML.getInstance());
		if(!this.loggerExist(loggerName))return this.next.createLogger(loggerName);
		return this.createLoggerFromPropertie(loggerName);
	}
	
}
