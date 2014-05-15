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
import java.lang.reflect.InvocationTargetException;

public class LoggerFactory {
	private static LoggerFactory factory=null;
	private LoggerFactory(){};
	public static LoggerFactory newInstance(){
		if(LoggerFactory.factory!=null){
			return LoggerFactory.factory;
		}
		LoggerFactory.factory=new LoggerFactory();
		return LoggerFactory.factory;
	}
	public Logger createLogger(String path){
		BasicLogger logger=new BasicLogger();
		
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return logger;
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(fXmlFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return logger;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return logger;
		}
	 
		doc.getDocumentElement().normalize(); 
		NodeList nList = doc.getElementsByTagName("log");	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				String levelType=eElement.getElementsByTagName("level").item(0).getTextContent();
				String baseFormat=eElement.getElementsByTagName("baseformat").item(0).getTextContent();
				String filename=eElement.getElementsByTagName("filename").item(0).getTextContent();
				String delimiter=eElement.getElementsByTagName("delimiter").item(0).getTextContent();

				Class classLevel;
				try {
					classLevel = Class.forName("ar.fiuba.tecnicas.logging.level."+levelType+"Level");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				Level level;
				try {
					level = (Level) classLevel.getMethod("getInstance").invoke(null,null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				BasicLogConfiguration logConfig=new BasicLogConfiguration(baseFormat,level,filename,delimiter);
				AbstractLog log;
				String consola="stdout";
				if (filename.equals(consola)){
					System.out.println("es consola " + filename);
					log=new ConsoleLog(logConfig);
				}else{
					log=new FileLog(logConfig);
				}
				logger.addLog(log);
			}
		}
		
		return logger;
	}
	
}
