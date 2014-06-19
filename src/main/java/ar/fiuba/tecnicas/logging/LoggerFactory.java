package ar.fiuba.tecnicas.logging;

/**
 * This class create the logger from the configuration log file with all the logs specified.
 *
 */
public class LoggerFactory {
	private static LoggerFactory factory = new LoggerFactory();
	private String path="logger-config";
	
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
		LoggerFactoryHandler loggerFactoryHandler=LoggerFactoryFromPropertie.getInstance();
		loggerFactoryHandler.setPropertiesPath(this.path);
		return loggerFactoryHandler.createLogger(loggerName);
	}
	
	public void setPropertiesPath(String path){
		this.path=path;
	}
	
}
