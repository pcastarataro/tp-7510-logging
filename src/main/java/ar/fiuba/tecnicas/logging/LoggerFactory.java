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

public class LoggerFactory {
	private static LoggerFactory factory=new LoggerFactory();
	private LoggerFactory(){};
	public static LoggerFactory newInstance(){
		return LoggerFactory.factory;
	}
	public Logger createLogger(String path){
		BasicLogger logger=new BasicLogger();
		Document configXml=this.getConfigXml(path);
		if(configXml!=null){
			NodeList nList = configXml.getElementsByTagName("log");	 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node logNode = nList.item(temp);
				if (logNode.getNodeType() == Node.ELEMENT_NODE) {
					Log log=this.createLog(logNode);
					if(log==null){
						continue;
					}
					logger.addLog(log);
				}
			}
		}
		return logger;
	}
	
	private Document getConfigXml(String path){
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document configXml=dBuilder.parse(fXmlFile);
			configXml.getDocumentElement().normalize();
			return configXml;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
		BasicLogConfiguration logConfig=new BasicLogConfiguration(baseFormat,level,filename,delimiter);
		AbstractLog log;
		String consola="stdout";
		if (filename.equals(consola)){
			log=new ConsoleLog(logConfig);
		}else{
			log=new FileLog(logConfig);
		}
		return log;
	}
	
}
