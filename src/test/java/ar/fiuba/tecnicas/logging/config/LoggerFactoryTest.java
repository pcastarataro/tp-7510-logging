package ar.fiuba.tecnicas.logging.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ar.fiuba.tecnicas.logging.ILogger;
import ar.fiuba.tecnicas.logging.Logger;
import ar.fiuba.tecnicas.logging.LoggerFactory;
import ar.fiuba.tecnicas.logging.LoggerFactoryDefault;
import ar.fiuba.tecnicas.logging.filter.IFilter;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.IOutput;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.ConsoleOutput;
import ar.fiuba.tecnicas.logging.log.FileOutput;
import ar.fiuba.tecnicas.logging.log.OutputFactory;
import junit.framework.TestCase;

public class LoggerFactoryTest extends TestCase {
	
	public void testCreateLoggerFromXml(){
		BufferedWriter out;
		String xmlCreatedLogger="";
		String xmlWanted="";
		String path="testCreateLoggerFromXml";
		try {
			out = new BufferedWriter(new FileWriter(path+".xml"));
			
			out.write("<?xml version=\"1.0\"?>");out.newLine();
			out.write("<loggers>");out.newLine();
			out.write("<logger name=\"Main\" level=\"Warn\">");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.ConsoleOutput:</outputstring>");out.newLine();
			out.write("<delimiter>:</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%F-%L-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt</outputstring>");out.newLine();
			out.write("<filters>");out.newLine();
			out.write("<filterpattern>.*Mundo.*</filterpattern>");out.newLine();
			out.write("<customFilter class=\"ar.fiuba.tecnicas.logging.filter.FilterMock\">");
			out.write("configuraciondefilter1");
			out.write("</customFilter>");out.newLine();
			out.write("</filters>");out.newLine();
			out.write("<delimiter>;</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.write("<logger name=\"logger2\" level=\"Warn\">");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:logger2.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.write("</loggers>");out.newLine();
			
			out.close();
			
			out = new BufferedWriter(new FileWriter(path+".properties"));
			out.write("loggers= org.slf4j.Logger,logger3");out.newLine();
			out.write("org.slf4j.Logger.logs= log1,log2,log3");out.newLine();
			out.write("org.slf4j.Logger.level=Debug");out.newLine();
			out.write("org.slf4j.Logger.log1.baseformat=%%%%% %g %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}");out.newLine();
			out.write("org.slf4j.Logger.log1.outputstring=ar.fiuba.tecnicas.logging.log.ConsoleOutput:");out.newLine();
			out.write("org.slf4j.Logger.log1.delimiter=:");out.newLine();
			out.write("org.slf4j.Logger.log2.baseformat=%g%d{HH:mm:ss}-%p%n-%t-%m");out.newLine();
			out.write("org.slf4j.Logger.log2.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt");out.newLine();
			out.write("org.slf4j.Logger.log2.delimiter=_");out.newLine();
			out.write("org.slf4j.Logger.log3.baseformat=%g%d{HH:mm:ss}-%F-%n%L-%m");out.newLine();
			out.write("org.slf4j.Logger.log3.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt");out.newLine();
			out.write("org.slf4j.Logger.log3.delimiter=#");out.newLine();
			out.write("org.slf4j.Logger.log3.filters=filter1,filter2,filter3");out.newLine();
			out.write("org.slf4j.Logger.log3.filter1.regex=.*probando.*");out.newLine();
			out.write("org.slf4j.Logger.log3.filter2.class=ar.fiuba.tecnicas.logging.filter.FilterMock");out.newLine();
			out.write("org.slf4j.Logger.log3.filter2.conf=configuraciondefilter2");out.newLine();
			out.write("logger3.level=Error");out.newLine();
			out.write("logger3.logs= log1");out.newLine();
			out.write("logger3.log1.baseformat=%g%d{HH:mm:ss}-%F-%n%L-%m");out.newLine();
			out.write("logger3.log1.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt");out.newLine();
			out.write("logger3.log1.delimiter=#");out.newLine();
			
			out.close();
			
			Logger loggerWanted=new Logger("Main");
			loggerWanted.setMinLoggingLevel(new Level(LevelPriority.WARN));
			LogConfiguration logConfig=new LogConfiguration("%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}",ConsoleOutput.class.getName() + ":",":");
			IOutput output=OutputFactory.getInstance().makeOutputForOutputString(ConsoleOutput.class.getName() + ":");
			Log log=new Log(logConfig, output);
			loggerWanted.addLog(log);
			
			logConfig=new LogConfiguration("%d{HH:mm:ss}-%p-%t-%m",FileOutput.class.getName() + ":log1.txt","-");
			output=OutputFactory.getInstance().makeOutputForOutputString(FileOutput.class.getName() + ":log1.txt");
			log=new Log(logConfig, output);
			loggerWanted.addLog(log);
			
			logConfig=new LogConfiguration("%d{HH:mm:ss}-%F-%L-%m",FileOutput.class.getName() + ":log2.txt",";");
			output=OutputFactory.getInstance().makeOutputForOutputString(FileOutput.class.getName() + ":log2.txt");
			log=new Log(logConfig, output);
			log.setRegexpPattern(".*Mundo.*");
			try {
				IFilter filter=(IFilter)Class.forName("ar.fiuba.tecnicas.logging.filter.FilterMock").getConstructor().newInstance();
				filter.setConfigurationString("configuraciondefilter1");
				log.addFilter(filter);
			} catch (Exception ex) {
		    	
		    }
			loggerWanted.addLog(log);
			
			xmlWanted=loggerWanted.getXmlConfig();
			LoggerFactory factory=LoggerFactory.getInstance();
			
			factory.setPropertiesPath(path);
			ILogger loggerGenerated=factory.createLogger("Main");
			xmlCreatedLogger=loggerGenerated.getXmlConfig();
			File file=new File(path+".xml");
			file.delete();
			file=new File(path+".properties");
			file.delete();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//System.out.println(xmlCreatedLogger);
        assertEquals(xmlWanted,xmlCreatedLogger);
	}
	
	public void testCreateLoggerFromPropertie(){
		BufferedWriter out;
		String xmlCreatedLogger="";
		String xmlWanted="";
		String path="testCreateLoggerFromPropertie";
		try {
			out = new BufferedWriter(new FileWriter(path+".xml"));
			
			out.write("<?xml version=\"1.0\"?>");out.newLine();
			out.write("<loggers>");out.newLine();
			out.write("<logger name=\"Main\" level=\"Warn\">");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.ConsoleOutput:</outputstring>");out.newLine();
			out.write("<delimiter>:</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%F-%L-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt</outputstring>");out.newLine();
			out.write("<filters>");out.newLine();
			out.write("<filterpattern>.*Mundo.*</filterpattern>");out.newLine();
			out.write("<customFilter class=\"ar.fiuba.tecnicas.logging.filter.FilterMock\">");out.newLine();
			out.write("configuraciondefilter1");out.newLine();
			out.write("</customFilter>");out.newLine();
			out.write("</filters>");out.newLine();
			out.write("<delimiter>;</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.write("<logger name=\"logger2\" level=\"Warn\">");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:logger2.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.write("</loggers>");out.newLine();
			
			out.close();
			
			out = new BufferedWriter(new FileWriter(path+".properties"));
			out.write("loggers= org.slf4j.Logger,logger3");out.newLine();
			out.write("org.slf4j.Logger.logs= log1,log2,log3");out.newLine();
			out.write("org.slf4j.Logger.level=Debug");out.newLine();
			out.write("org.slf4j.Logger.log1.baseformat=%%%%% %g %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}");out.newLine();
			out.write("org.slf4j.Logger.log1.outputstring=ar.fiuba.tecnicas.logging.log.ConsoleOutput:");out.newLine();
			out.write("org.slf4j.Logger.log1.delimiter=:");out.newLine();
			out.write("org.slf4j.Logger.log2.baseformat=%g%d{HH:mm:ss}-%p%n-%t-%m");out.newLine();
			out.write("org.slf4j.Logger.log2.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt");out.newLine();
			out.write("org.slf4j.Logger.log2.delimiter=_");out.newLine();
			out.write("org.slf4j.Logger.log3.baseformat=%g%d{HH:mm:ss}-%F-%n%L-%m");out.newLine();
			out.write("org.slf4j.Logger.log3.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt");out.newLine();
			out.write("org.slf4j.Logger.log3.delimiter=#");out.newLine();
			out.write("org.slf4j.Logger.log3.filters=filter1,filter2,filter3");out.newLine();
			out.write("org.slf4j.Logger.log3.filter1.regex=.*probando.*");out.newLine();
			out.write("org.slf4j.Logger.log3.filter2.class=ar.fiuba.tecnicas.logging.filter.FilterMock");out.newLine();
			out.write("org.slf4j.Logger.log3.filter2.conf=configuraciondefilter2");out.newLine();
			out.write("logger3.level=Error");out.newLine();
			out.write("logger3.logs= log1");out.newLine();
			out.write("logger3.log1.baseformat=%g%d{HH:mm:ss}-%F-%n%L-%m");out.newLine();
			out.write("logger3.log1.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt");out.newLine();
			out.write("logger3.log1.delimiter=#");out.newLine();
			
			out.close();
			
			Logger loggerWanted=new Logger("org.slf4j.Logger");
			loggerWanted.setMinLoggingLevel(new Level(LevelPriority.DEBUG));
			LogConfiguration logConfig=new LogConfiguration("%%%%% %g %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}",ConsoleOutput.class.getName() + ":",":");
			
			IOutput output=OutputFactory.getInstance().makeOutputForOutputString(ConsoleOutput.class.getName() + ":");
			Log log=new Log(logConfig, output);
			loggerWanted.addLog(log);
			
			logConfig=new LogConfiguration("%g%d{HH:mm:ss}-%p%n-%t-%m",FileOutput.class.getName() + ":log1.txt","_");
			output=OutputFactory.getInstance().makeOutputForOutputString(FileOutput.class.getName() + ":log1.txt");
			log=new Log(logConfig, output);
			loggerWanted.addLog(log);
			
			logConfig=new LogConfiguration("%g%d{HH:mm:ss}-%F-%n%L-%m",FileOutput.class.getName() + ":log2.txt","#");
			output=OutputFactory.getInstance().makeOutputForOutputString(FileOutput.class.getName() + ":log2.txt");
			log=new Log(logConfig, output);
			log.setRegexpPattern(".*probando.*");
			
			try {
				IFilter filter=(IFilter)Class.forName("ar.fiuba.tecnicas.logging.filter.FilterMock").getConstructor().newInstance();
				filter.setConfigurationString("configuraciondefilter2");
				log.addFilter(filter);
			} catch (Exception ex) {
		    	
		    }
			
			loggerWanted.addLog(log);
			
			xmlWanted=loggerWanted.getXmlConfig();
			LoggerFactory factory=LoggerFactory.getInstance();
			
			factory.setPropertiesPath(path);
			ILogger loggerGenerated=factory.createLogger("org.slf4j.Logger");
			xmlCreatedLogger=loggerGenerated.getXmlConfig();
			File file=new File(path+".xml");
			file.delete();
			file=new File(path+".properties");
			file.delete();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
        assertEquals(xmlWanted,xmlCreatedLogger);
	}
	
	public void testCreateLoggerDefault(){
		BufferedWriter out;
		String xmlCreatedLogger="";
		String xmlWanted="";
		String path="testCreateLoggerDefault";
		try {
			out = new BufferedWriter(new FileWriter(path+".xml"));
			
			out.write("<?xml version=\"1.0\"?>");out.newLine();
			out.write("<loggers>");out.newLine();
			out.write("<logger name=\"Main\" level=\"Warn\">");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.ConsoleOutput:</outputstring>");out.newLine();
			out.write("<delimiter>:</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%F-%L-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt</outputstring>");out.newLine();
			out.write("<filters>");out.newLine();
			out.write("<filterpattern>.*Mundo.*</filterpattern>");out.newLine();
			out.write("<customFilter class=\"ar.fiuba.tecnicas.logging.filter.FilterMock\">");out.newLine();
			out.write("</customFilter>");out.newLine();
			out.write("</filters>");out.newLine();
			out.write("<delimiter>;</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.write("<logger name=\"logger2\" level=\"Warn\">");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:logger2.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.write("</loggers>");out.newLine();
			
			out.close();
			
			out = new BufferedWriter(new FileWriter(path+".properties"));
			out.write("loggers= org.slf4j.Logger,logger3");out.newLine();
			out.write("org.slf4j.Logger.logs= log1,log2,log3");out.newLine();
			out.write("org.slf4j.Logger.level=Debug");out.newLine();
			out.write("org.slf4j.Logger.log1.baseformat=%%%%% %g %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}");out.newLine();
			out.write("org.slf4j.Logger.log1.outputstring=ar.fiuba.tecnicas.logging.log.ConsoleOutput:");out.newLine();
			out.write("org.slf4j.Logger.log1.delimiter=:");out.newLine();
			out.write("org.slf4j.Logger.log2.baseformat=%g%d{HH:mm:ss}-%p%n-%t-%m");out.newLine();
			out.write("org.slf4j.Logger.log2.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt");out.newLine();
			out.write("org.slf4j.Logger.log2.delimiter=_");out.newLine();
			out.write("org.slf4j.Logger.log3.baseformat=%g%d{HH:mm:ss}-%F-%n%L-%m");out.newLine();
			out.write("org.slf4j.Logger.log3.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt");out.newLine();
			out.write("org.slf4j.Logger.log3.delimiter=#");out.newLine();
			out.write("org.slf4j.Logger.log3.filters=filter1,filter2,filter3");out.newLine();
			out.write("org.slf4j.Logger.log3.filter1.regex=.*probando.*");out.newLine();
			out.write("org.slf4j.Logger.log3.filter2.class=ar.fiuba.tecnicas.logging.filter.FilterMock");out.newLine();
			out.write("org.slf4j.Logger.log3.filter2.conf=configuraciondefilter2");out.newLine();
			out.write("logger3.level=Error");out.newLine();
			out.write("logger3.logs= log1");out.newLine();
			out.write("logger3.log1.baseformat=%g%d{HH:mm:ss}-%F-%n%L-%m");out.newLine();
			out.write("logger3.log1.outputstring=ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt");out.newLine();
			out.write("logger3.log1.delimiter=#");out.newLine();
			
			out.close();
			
			LoggerFactoryDefault factoryDefault=LoggerFactoryDefault.getInstance();
			ILogger loggerWanted=factoryDefault.createLogger("LoggerInexistente");
			
			xmlWanted=loggerWanted.getXmlConfig();
			LoggerFactory factory=LoggerFactory.getInstance();
			
			factory.setPropertiesPath(path);
			ILogger loggerGenerated=factory.createLogger("LoggerInexistente");
			xmlCreatedLogger=loggerGenerated.getXmlConfig();
			File file=new File(path+".xml");
			file.delete();
			file=new File(path+".properties");
			file.delete();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        assertEquals(xmlWanted,xmlCreatedLogger);
	}
}

