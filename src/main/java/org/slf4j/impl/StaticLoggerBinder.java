package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * Class that implements the LoggerFactoryBinder for SLF4J. 
 *
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

	private static final StaticLoggerBinder instance = new StaticLoggerBinder();
	private final ILoggerFactory factory;
	
	private StaticLoggerBinder() {
		factory = new SLF4JLoggerFactory();
	}
	
	/**
	 * Requested SLF4J API version
	 */
	public static String REQUESTED_API_VERSION ="1.7.7";
	
	/**
	 * Returns the unique Static Logger Instance
	 * @return
	 */
	public static StaticLoggerBinder getSingleton() {
		return instance;
	}
	
	/**
	 * Returns the Logger factory.
	 * @return
	 */
	@Override
	public ILoggerFactory getLoggerFactory() {
		return factory;
	}

	/**
	 * Returns the LoggerFactory class name.
	 * @return
	 */
	@Override
	public String getLoggerFactoryClassStr() {
		return SLF4JLoggerFactory.class.getName();
	}

}
