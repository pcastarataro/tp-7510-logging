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
	private static OutputFactory outputFactory = new ConcreteOutputFactory();
	
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
	public Logger createLogger(String loggerName) {
		return LoggerFactoryFromPropertie.getInstance().createLogger(loggerName);
	}
	
}
