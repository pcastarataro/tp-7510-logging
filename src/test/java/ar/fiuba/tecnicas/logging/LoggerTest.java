package ar.fiuba.tecnicas.logging;

import junit.framework.TestCase;
import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.filter.IFilter;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ConsoleOutput;
import ar.fiuba.tecnicas.logging.log.FileOutput;
import ar.fiuba.tecnicas.logging.log.IOutput;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.OutputFactory;

public class LoggerTest extends TestCase{
	public void testLoggerGetAsXml(){
		
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
		
		String xmlCreatedLogger=loggerWanted.getXmlConfig();
		
		String xmlWanted="<logger name=\"Main\" level=\"WARN\">";
		xmlWanted+="<log>";
		xmlWanted+="<baseformat>%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}</baseformat>";
		xmlWanted+="<outputstring>ar.fiuba.tecnicas.logging.log.ConsoleOutput:</outputstring>";
		xmlWanted+="<delimiter>:</delimiter>";
		xmlWanted+="</log>";
		xmlWanted+="<log>";
		xmlWanted+="<baseformat>%d{HH:mm:ss}-%p-%t-%m</baseformat>";
		xmlWanted+="<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log1.txt</outputstring>";
		xmlWanted+="<delimiter>-</delimiter>";
		xmlWanted+="</log>";
		xmlWanted+="<log>";
		xmlWanted+="<baseformat>%d{HH:mm:ss}-%F-%L-%m</baseformat>";
		xmlWanted+="<outputstring>ar.fiuba.tecnicas.logging.log.FileOutput:log2.txt</outputstring>";
		xmlWanted+="<delimiter>;</delimiter>";
		xmlWanted+="<filters>";
		xmlWanted+="<filterpattern>.*Mundo.*</filterpattern>";
		xmlWanted+="<customFilter class=\"ar.fiuba.tecnicas.logging.filter.FilterMock\">";
		xmlWanted+="configuraciondefilter1";
		xmlWanted+="</customFilter>";
		xmlWanted+="</filters>";
		xmlWanted+="</log>";
		xmlWanted+="</logger>";
		
        assertEquals(xmlWanted,xmlCreatedLogger);
	}
}
