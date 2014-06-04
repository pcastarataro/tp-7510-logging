package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.format.DateFormatter;
import ar.fiuba.tecnicas.logging.format.LevelFormatter;
import ar.fiuba.tecnicas.logging.format.MessageFormatter;

/**
 * This class allows to format one message as JSON
 *
 */
public class JsonFormatter extends AbstractFormatter {
	
	private DateFormatter dateFormatter;
	private LevelFormatter levelFormatter;
	private MessageFormatter messageFormatter;
	private LoggerNameFormatter loggerNameFormatter;

	/**
	 * Constructor
	 */
	public JsonFormatter() {
		dateFormatter = new DateFormatter();
		levelFormatter = new LevelFormatter();
		messageFormatter = new MessageFormatter();
		loggerNameFormatter = new LoggerNameFormatter();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ar.fiuba.tecnicas.logging.format.Formatter#preProcessFormat(java.lang.String, ar.fiuba.tecnicas.logging.format.LogParameter)
	 */
	@Override
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		String preformattedStr = baseFormat.replace("%J", "{'datetime':'%d{yyyy-MM-dd}T%d{HH:mm:ss.SSSZ}','level':'%p','logger':'%g','message':'%m'}");
		preformattedStr = dateFormatter.preProcessFormat(preformattedStr, parameters);
		preformattedStr = levelFormatter.preProcessFormat(preformattedStr, parameters);
		preformattedStr = messageFormatter.preProcessFormat(preformattedStr, parameters);
		preformattedStr = loggerNameFormatter.preProcessFormat(preformattedStr, parameters);
		return preformattedStr;
	}
	
}
