package ar.fiuba.tecnicas.logging.config;

import junit.framework.TestCase;

public class LogConfigurationTest extends TestCase {
	
	private String DEFAULT_DELIMITER = "-";
	
	private String baseFormat = "%d{HH:mm:ss}-%F-%L-%m";
	private String outputString = "ar.fiuba.tecnicas.logging.log.FileOutput:log.txt";
	private String delimiter = "||";
	
	String xmlConfig = "<log><baseformat>" + baseFormat + "</baseformat><outputstring>" + outputString + "</outputstring><delimiter>" + delimiter + "</delimiter></log>";

	private LogConfiguration logConfiguration;
		
	public void testGetDelimiter() {
		logConfiguration = new LogConfiguration(baseFormat, outputString, delimiter);
		assertEquals(delimiter, logConfiguration.getDelimiter());
	}
	
	public void testGetDefaultDelimiter() {
		logConfiguration = new LogConfiguration(baseFormat);
		assertEquals(DEFAULT_DELIMITER, logConfiguration.getDelimiter());
	}
	
	public void testGetbaseFormat() {
		logConfiguration = new LogConfiguration(baseFormat);
		assertEquals(baseFormat, logConfiguration.getBaseFormat());
	}
	
	public void testGetOutputString() {
		logConfiguration = new LogConfiguration(baseFormat, outputString);
		assertEquals(outputString, logConfiguration.outputString());
	}
	
	public void testGetAsXml() {
		logConfiguration = new LogConfiguration(baseFormat, outputString, delimiter);
		assertEquals(xmlConfig, logConfiguration.getAsXml());
	}
}
