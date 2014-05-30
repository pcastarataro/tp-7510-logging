package ar.fiuba.tecnicas.logging.format;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of Logger Name in an string. 
 *
 */
public class LoggerNameFormatter extends AbstractFormatter{
	
	/**
	 * Replace all the occurrences of loggerName pattern with the Logger Name.
	 */
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String loggerName = (String) parameters.getParameterNamed("loggerName");
		return baseFormat.replace("%g", loggerName);
	}
}
