package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import junit.framework.TestCase;

public class LogTest  extends TestCase{
	public void testLogGetAsXml(){
		LogConfiguration logConfig=new LogConfiguration("%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}",ConsoleOutput.class.getName() + ":",":");
		IOutput output=OutputFactory.getInstance().makeOutputForOutputString(ConsoleOutput.class.getName() + ":");
		Log log=new Log(logConfig, output);
		String xmlCreatedLog=log.getAsXml();
		String xmlLogWanted="<log>";
		xmlLogWanted+="<baseformat>%%%%%F %t %n %L %n %M HOLAAA %F %n %m %n %%  %p %d{yyyy} %d{M} %d{yyyy-MM}</baseformat>";
		xmlLogWanted+="<outputstring>ar.fiuba.tecnicas.logging.log.ConsoleOutput:</outputstring>";
		xmlLogWanted+="<delimiter>:</delimiter>";
		xmlLogWanted+="</log>";
        assertEquals(xmlLogWanted,xmlCreatedLog);
	}
}
