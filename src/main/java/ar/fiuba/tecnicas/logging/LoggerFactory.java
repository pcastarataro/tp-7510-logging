package ar.fiuba.tecnicas.logging;
import ar.fiuba.tecnicas.logging.config.*;
import ar.fiuba.tecnicas.logging.log.*;
import ar.fiuba.tecnicas.logging.level.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * This class create the logger from the configuration log file with all the logs specified.
 *
 */
public class LoggerFactory {
	private static LoggerFactory factory = new LoggerFactory();
	
	private LoggerFactory() {};
	
	/**
	 * @return Unique intance of Logger factory
	 */
	public static LoggerFactory getInstance() {
		return LoggerFactory.factory;
	}
	
	/**
	 * This method create a logger from the configuration log file
	 * @param path config file route
	 * @return Logger with its log created ready to log
	 */
	public Logger createLogger(String path) {
		BasicLogger logger = new BasicLogger();
		try {
			Document configXml;
			configXml = this.getConfigXml(path);
			NodeList nList = configXml.getElementsByTagName("log");	 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node logNode = nList.item(temp);
				if (logNode.getNodeType() == Node.ELEMENT_NODE) {
					Log log=this.createLog(logNode);
					logger.addLog(log);
				}
			}
		} 
		catch (ParserConfigurationException e) {} 
		catch (SAXException e) {} 
		catch (IOException e) {}
		return logger;
	}
	
	private Document getConfigXml(String path) throws ParserConfigurationException, 
										SAXException, IOException { 
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document configXml=dBuilder.parse(fXmlFile);
		configXml.getDocumentElement().normalize();
		return configXml;
	}
	
	// In case of invalid name returns Lower priority level as default
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
	
	private Log createLog(Node logNode){
		Element eElement = (Element) logNode;
		String levelType=eElement.getElementsByTagName("level").item(0).getTextContent();
		String baseFormat=eElement.getElementsByTagName("baseformat").item(0).getTextContent();
		String filename=eElement.getElementsByTagName("filename").item(0).getTextContent();
		String delimiter=eElement.getElementsByTagName("delimiter").item(0).getTextContent();

		Level level=getLevelFromName(levelType);
		LogConfiguration logConfig=new BasicLogConfiguration(baseFormat,level,filename,delimiter);
		ConcreteLog log = getLogForFileName(filename, logConfig);
		return log;
	}
	
	private ConcreteLog getLogForFileName(String fileName, LogConfiguration config) {
		Output output = getLogOutputForFileName(fileName);
		ConcreteLog log = new ConcreteLog(config, output);
		return log;
	}
	
	private Output getLogOutputForFileName(String fileName) {
		Output output;
		String consola="stdout";
		if (fileName.equals(consola)){
			output = new ConsoleOutput();
		}else{
			output = new FileOutput(fileName);
		}
		return output;
	}
	
}
