package ar.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.logging.format.DateFormatter;
import ar.fiuba.tecnicas.logging.format.DelimiterFormatter;
import ar.fiuba.tecnicas.logging.format.EscapeFormatter;
import ar.fiuba.tecnicas.logging.format.FileNameFormatter;
import ar.fiuba.tecnicas.logging.format.IFormatter;
import ar.fiuba.tecnicas.logging.format.LevelFormatter;
import ar.fiuba.tecnicas.logging.format.LineNumberFormatter;
import ar.fiuba.tecnicas.logging.format.LoggerNameFormatter;
import ar.fiuba.tecnicas.logging.format.MessageFormatter;
import ar.fiuba.tecnicas.logging.format.MethodNameFormatter;
import ar.fiuba.tecnicas.logging.format.ThreadNameFormatter;
import ar.fiuba.tecnicas.logging.format.JsonFormatter;

/**
 * Repository of all kind of implemented formatters to be used to log
 */
public class FormatterRepository {

	private List<IFormatter> formattersList;
	
	private static FormatterRepository instance = new FormatterRepository();
	
	private FormatterRepository() {
		loadFormatters();
	}
	
	private void loadFormatters() {
		formattersList = new ArrayList<IFormatter>();
		IFormatter escapeFormatter = new EscapeFormatter();
		IFormatter threadNameFormatter = new ThreadNameFormatter();
		IFormatter lineNumberFormatter = new LineNumberFormatter();
		IFormatter delimiterFormatter = new DelimiterFormatter();
		IFormatter fileNameFormatter = new FileNameFormatter();
		IFormatter methodNameFormatter = new MethodNameFormatter();
		IFormatter messageNameFormatter = new MessageFormatter();
		IFormatter levelFormatter = new LevelFormatter();
		IFormatter dateFormatter = new DateFormatter();
		IFormatter loggerNameFormatter= new LoggerNameFormatter();
		IFormatter jsonFormatter= new JsonFormatter();
		
		formattersList.add(escapeFormatter);
		formattersList.add(threadNameFormatter);
		formattersList.add(lineNumberFormatter);
		formattersList.add(delimiterFormatter);
		formattersList.add(fileNameFormatter);
		formattersList.add(methodNameFormatter);
		formattersList.add(messageNameFormatter);
		formattersList.add(levelFormatter);
		formattersList.add(dateFormatter);
		formattersList.add(loggerNameFormatter);
		formattersList.add(jsonFormatter);
	}
	
	/**
	 * @return unique instance of FormatterRepository
	 */
	public static FormatterRepository getInstance() {
		return instance;
	}
	
	/**
	 * @return List with all the existing implemented formatters
	 */
	public List<IFormatter> getFormatters() {
		return formattersList;
	}
}
