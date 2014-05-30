package ar.fiuba.tecnicas.logging.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ar.fiuba.tecnicas.logging.ConcreteLogger;
import ar.fiuba.tecnicas.logging.Logger;
import ar.fiuba.tecnicas.logging.LoggerFactory;
import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ConcreteLog;
import ar.fiuba.tecnicas.logging.log.ConsoleOutput;
import ar.fiuba.tecnicas.logging.log.FileOutput;
import ar.fiuba.tecnicas.logging.log.Log;
import junit.framework.TestCase;

public class LoggerFactoryTest extends TestCase {
	
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
			out.write("<outputstring>" + ConsoleOutput.class.getName() + ":</outputstring>");out.newLine();
			out.write("<delimiter>:</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("<log>");out.newLine();
			out.write("<level>Info</level>");out.newLine();
			out.write("<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>");out.newLine();
			out.write("<outputstring>" + FileOutput.class.getName() + ":log1.txt</outputstring>");out.newLine();
			out.write("<delimiter>-</delimiter>");out.newLine();
			out.write("</log>");out.newLine();
			out.write("</logger>");out.newLine();
			out.close();
			Logger loggerWanted=new ConcreteLogger("TestLogger");
			LogConfiguration logConfig=new ConcreteLogConfiguration("%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}",
					new ConcreteLevel(LevelPriority.DEBUG),ConsoleOutput.class.getName() + ":",":");
			Log log=new ConcreteLog(logConfig, new ConsoleOutput());
			loggerWanted.addLog(log);
			logConfig=new ConcreteLogConfiguration("%d{HH:mm:ss}-%p-%t-%m", new ConcreteLevel(LevelPriority.INFO), FileOutput.class.getName() + ":log1.txt","-");
			log=new ConcreteLog(logConfig, new ConsoleOutput());
			loggerWanted.addLog(log);
			xmlWanted=loggerWanted.getXmlConfig();
			Logger loggerGenerated=LoggerFactory.getInstance().createLogger(path);
			xmlCreatedLogger=loggerGenerated.getXmlConfig();
			File file=new File(path);
			file.delete();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        assertEquals(xmlCreatedLogger,xmlWanted);
	}
}
