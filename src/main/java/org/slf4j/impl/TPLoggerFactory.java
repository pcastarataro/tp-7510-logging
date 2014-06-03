package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import ar.fiuba.tecnicas.logging.LoggerFactory;

/**
 * This class abstract the creation of Logs.
 *
 */
public class TPLoggerFactory implements ILoggerFactory {

	private LoggerFactory loggerFactory;
	private TPLogger logger;
	
	/**
	 * Constructor. Creates an instance of LoggerFactory.
	 */
	public TPLoggerFactory() {
		this.loggerFactory = LoggerFactory.getInstance();
		this.logger = new TPLogger(loggerFactory.createLogger("config.txt"));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
	 */
	@Override
	public Logger getLogger(String name) {
		return logger;
	}

}
