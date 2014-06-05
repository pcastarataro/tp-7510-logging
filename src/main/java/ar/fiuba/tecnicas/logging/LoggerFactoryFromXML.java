package ar.fiuba.tecnicas.logging;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ar.fiuba.tecnicas.logging.config.ConcreteLogConfiguration;
import ar.fiuba.tecnicas.logging.config.LogConfiguration;
import ar.fiuba.tecnicas.logging.filter.Filter;
import ar.fiuba.tecnicas.logging.level.ConcreteLevel;
import ar.fiuba.tecnicas.logging.level.Level;
import ar.fiuba.tecnicas.logging.level.LevelPriority;
import ar.fiuba.tecnicas.logging.log.ConcreteLog;
import ar.fiuba.tecnicas.logging.log.ConcreteOutputFactory;
import ar.fiuba.tecnicas.logging.log.Log;
import ar.fiuba.tecnicas.logging.log.Output;

public class LoggerFactoryFromXML implements LoggerFactoryHandler {
	private static LoggerFactoryFromXML factory = new LoggerFactoryFromXML();
	private String path="logger-config.xml";
	private Document loggerConfig;
	private LoggerFactoryHandler next;
	
	public LoggerFactoryFromXML(){
		try{
			this.loggerConfig=this.getConfigXml(this.path);
		}
		catch (ParserConfigurationException e) {this.loggerConfig=null;} 
		catch (SAXException e) {this.loggerConfig=null;} 
		catch (IOException e) {this.loggerConfig=null;}
	}
	
	public LoggerFactoryHandler getNext(){
		return LoggerFactoryDefault.getInstance();
	}
	
	public void setNext(LoggerFactoryHandler handler){
		this.next=handler;
	}
	
	public static LoggerFactoryFromXML getInstance() {
		return LoggerFactoryFromXML.factory;
	}
	
	private Node getLogger(String loggerName){
		NodeList nList = this.loggerConfig.getElementsByTagName("logger");	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node loggerNode = nList.item(temp);
			NamedNodeMap attrs=loggerNode.getAttributes();
			
			Node nodeName=attrs.getNamedItem("name");
			if(nodeName==null){
				continue;
			}
			String name=nodeName.getTextContent();
			if(name.equals(loggerName)){
				return loggerNode;
			}
		}
		return null;
	}
	
	private boolean loggerExist(String loggerName){
		if(this.loggerConfig==null){
			return false;
		}
		if(this.getLogger(loggerName)==null){
			return false;
		}
		return true;
	}	
	
	private Logger createLoggerFromXML(String loggerName){
		ConcreteLogger logger = new ConcreteLogger(loggerName);
		Node loggerNode=this.getLogger(loggerName);
		
		NamedNodeMap attrs=loggerNode.getAttributes();
		
		String level=attrs.getNamedItem("level").getTextContent();
		
		logger.setMinLoggingLevel(getLevelFromName(level));
		Element loggerElement=(Element) loggerNode;
		NodeList nList = loggerElement.getElementsByTagName("log");	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node logNode = nList.item(temp);
			if (logNode.getNodeType() == Node.ELEMENT_NODE) {
				//System.out.println("crea log");
				Log log=this.createLog(logNode);
				logger.addLog(log);
			}
		}
		return logger;
	}
	
	public Logger createLogger(String loggerName) {
		this.setNext(LoggerFactoryDefault.getInstance());
		if (!this.loggerExist(loggerName)){
			return this.next.createLogger(loggerName);
		}
		//System.out.println("crear logger");
		return this.createLoggerFromXML(loggerName);
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
	
	private Filter createFilter(Node filterNode){
		NamedNodeMap attrs=filterNode.getAttributes();
		String filterClassName=attrs.getNamedItem("class").getTextContent();
		Filter filter;
		try {
			filter=(Filter)Class.forName(filterClassName).getConstructor().newInstance();
			filter.setConfigurationString(filterNode.getTextContent());
		} catch (Exception ex) {
	    	return null;
	    }
		return null;
	}
	
	private void loadFilters(Log log,Node filtersNode){
		NodeList filtros=filtersNode.getChildNodes();
		for(int i=0;i<filtros.getLength();i++){
			Node filterNode=filtros.item(i);
			if (filterNode.getNodeType() == Node.ELEMENT_NODE) {
				//System.out.println(filterNode.getNodeName());
				if(filterNode.getNodeName().equals("filterpattern")){
					log.setRegexpPattern(filterNode.getTextContent());
					continue;
				}
				//System.out.println("no filter pattern");
				Filter filter=createFilter(filterNode);
				if(filter!=null){
					System.out.println("encuentra clase");
					log.addFilter(filter);
				}
			}
		}
	}
	
	private Log createLog(Node logNode) {
		Element eElement = (Element) logNode;
		String baseFormat = eElement.getElementsByTagName("baseformat").item(0).getTextContent();
		String filename = eElement.getElementsByTagName("outputstring").item(0).getTextContent();
		String delimiter = eElement.getElementsByTagName("delimiter").item(0).getTextContent();
		
		LogConfiguration logConfig = new ConcreteLogConfiguration(baseFormat, filename, delimiter);
		Output output=ConcreteOutputFactory.getInstance().makeOutputForOutputString(filename);
		Log log = new ConcreteLog(logConfig,output);
		//System.out.println(eElement.getElementsByTagName("filters").getLength());
		if(eElement.getElementsByTagName("filters").getLength()!=0){
			//System.out.println("entra a load filters");
			loadFilters(log,eElement.getElementsByTagName("filters").item(0));
		}
		
		return log;
	}
	
}
