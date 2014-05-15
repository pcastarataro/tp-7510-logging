package ar.fiuba.tecnicas.logging.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ar.fiuba.tecnicas.logging.BasicLogger;
import ar.fiuba.tecnicas.logging.Logger;
import ar.fiuba.tecnicas.logging.LoggerFactory;
import ar.fiuba.tecnicas.logging.level.DebugLevel;
import ar.fiuba.tecnicas.logging.level.InfoLevel;
import ar.fiuba.tecnicas.logging.log.ConsoleLog;
import ar.fiuba.tecnicas.logging.log.Log;

import junit.framework.TestCase;

public class LoggerFactoryTest extends TestCase{
	public void testCreateLoggerFromXml(){
		BufferedWriter out;
		String xmlCreatedLogger="";
		String xmlWanted="";
		String path="testCreateLoggerFromXml.txt";
		try {
			out = new BufferedWriter(new FileWriter(path));
			out.write("<?xml version=\"1.0\"?>");out.newLine();
			out.write("<logger>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<level>Debug</level>");out.newLine();
			out.write("<baseformat>%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}</baseformat>");out.newLine();
			out.write("<filename>stdout</filename>");out.newLine();
			out.write("<delimiter>:</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<level>Info</level>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<filename>log1.txt</filename>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.close();
			Logger loggerWanted=new BasicLogger();
			LogConfiguration logConfig=new BasicLogConfiguration("%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}",DebugLevel.getInstance(),"stdout",":");
			Log log=new ConsoleLog(logConfig);
			loggerWanted.addLog(log);
			logConfig=new BasicLogConfiguration("%d{HH:mm:ss}-%p-%t-%m",InfoLevel.getInstance(),"log1.txt","-");
			log=new ConsoleLog(logConfig);
			loggerWanted.addLog(log);
			xmlWanted=loggerWanted.getXmlConfig();
			Logger loggerGenerated=LoggerFactory.newInstance().createLogger(path);
			xmlCreatedLogger=loggerGenerated.getXmlConfig();
			File file=new File(path);
			file.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(xmlCreatedLogger,xmlWanted);
	}
}
