package ar.fiuba.tecnicas.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.config.ILogConfiguration;
import ar.fiuba.tecnicas.logging.filter.IFilter;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.ILevel;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.OutputFactory;
import ar.fiuba.tecnicas.logging.log.ILog;
import ar.fiuba.tecnicas.logging.log.IOutput;

public class LoggerFactoryFromPropertie implements LoggerFactoryHandler{
	private static LoggerFactoryFromPropertie factory=new LoggerFactoryFromPropertie();
	private Properties configProperties;
	private LoggerFactoryHandler next;
	private String path="logger-config";
	private String extension="properties";
	
	public LoggerFactoryFromPropertie(){
		try {
			InputStream input = new FileInputStream(this.path+"."+this.extension);
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
	
	private ILevel getLevelFromName(String name) {
		LevelPriority priority;
		try {
			priority = LevelPriority.valueOf(name.toUpperCase());
		}
		catch(RuntimeException e){
			priority = LevelPriority.values()[0];
		}
		return new Level(priority);
	}
	
	private IFilter createFilter(String filterFullName){
		String filterClassName= this.configProperties.getProperty(filterFullName+".class");
		IFilter filter;
		try {
			filter=(IFilter)Class.forName(filterClassName).getConstructor().newInstance();
			String filterConf= this.configProperties.getProperty(filterFullName+".conf");
			filter.setConfigurationString(filterConf);
		} catch (Exception ex) {
	    	return null;
	    }
		return filter;
	}
	
	private void loadFilters(ILog log,String logNameFull){
		String filters=this.configProperties.getProperty(logNameFull+".filters");
		if(filters!=null){
			String[] filtersName=filters.replaceAll(" ", "").split(",");
			for(int i=0;i<filtersName.length;i++){
				String regex=this.configProperties.getProperty(logNameFull+"."+filtersName[i]+".regex");
				if(regex!=null){
					log.setRegexpPattern(regex);
					continue;
				}
				IFilter filter=this.createFilter(logNameFull+"."+filtersName[i]);
				if(filter!=null){
					log.addFilter(filter);
				}
			}
		}
	}
	
	private ILog createLog(String logNameFull){
		String baseFormat = this.configProperties.getProperty(logNameFull+".baseformat");
		String filename = this.configProperties.getProperty(logNameFull+".outputstring");
		String delimiter = this.configProperties.getProperty(logNameFull+".delimiter");
		ILogConfiguration logConfig = new LogConfiguration(baseFormat, filename, delimiter);
		IOutput output=OutputFactory.getInstance().makeOutputForOutputString(filename);
		ILog log = new Log(logConfig,output);
		loadFilters(log,logNameFull);
		return log;	
	}
	
	private ILogger createLoggerFromPropertie(String loggerName){
		Logger logger = new Logger(loggerName);
		String loggerLevel=this.configProperties.getProperty(loggerName+".level");
		logger.setMinLoggingLevel(getLevelFromName(loggerLevel));
		String logs=this.configProperties.getProperty(loggerName+".logs");
		String[] logsNames=logs.replaceAll(" ", "").split(",");
		for(int i=0;i<logsNames.length;i++){
			ILog log=this.createLog(loggerName+"."+logsNames[i]);
			logger.addLog(log);
		}
		return logger;
	}
	
	public ILogger createLogger(String loggerName){
		this.setNext(LoggerFactoryFromXML.getInstance());
		if(!this.loggerExist(loggerName)){
			this.next.setPropertiesPath(this.path);
			return this.next.createLogger(loggerName);
		}
		return this.createLoggerFromPropertie(loggerName);
	}
	
	public void setPropertiesPath(String path){
		if(!this.path.equals(path)){
			this.path=path;
			try {
				InputStream input = new FileInputStream(this.path+"."+this.extension);
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
	}
	
}
