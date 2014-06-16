package ar.fiuba.tecnicas.logging;

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
	public ILogger createLogger(String loggerName) {
		return LoggerFactoryFromPropertie.getInstance().createLogger(loggerName);
	}
	
}
