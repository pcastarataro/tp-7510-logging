package ar.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.logging.format.DateFormatter;
import ar.fiuba.tecnicas.logging.format.DelimiterFormatter;
import ar.fiuba.tecnicas.logging.format.EscapeFormatter;
import ar.fiuba.tecnicas.logging.format.FileNameFormatter;
import ar.fiuba.tecnicas.logging.format.Formatter;
import ar.fiuba.tecnicas.logging.format.LevelFormatter;
import ar.fiuba.tecnicas.logging.format.LineNumberFormatter;
import ar.fiuba.tecnicas.logging.format.MessageFormatter;
import ar.fiuba.tecnicas.logging.format.MethodNameFormatter;
import ar.fiuba.tecnicas.logging.format.ThreadNameFormatter;

/**
 * Repository of all kind of implemented formatters to be used to log
 */
public class FormatterRepository {

	private List<Formatter> formattersList;
	
	private static FormatterRepository instance = new FormatterRepository();
	
	private FormatterRepository() {
		loadFormatters();
	}
	
	private void loadFormatters() {
		formattersList = new ArrayList<Formatter>();
		Formatter escapeFormatter = new EscapeFormatter();
		Formatter threadNameFormatter = new ThreadNameFormatter();
		Formatter lineNumberFormatter = new LineNumberFormatter();
		Formatter delimiterFormatter = new DelimiterFormatter();
		Formatter fileNameFormatter = new FileNameFormatter();
		Formatter methodNameFormatter = new MethodNameFormatter();
		Formatter messageNameFormatter = new MessageFormatter();
		Formatter levelFormatter = new LevelFormatter();
		Formatter dateFormatter = new DateFormatter();
		
		formattersList.add(escapeFormatter);
		formattersList.add(threadNameFormatter);
		formattersList.add(lineNumberFormatter);
		formattersList.add(delimiterFormatter);
		formattersList.add(fileNameFormatter);
		formattersList.add(methodNameFormatter);
		formattersList.add(messageNameFormatter);
		formattersList.add(levelFormatter);
		formattersList.add(dateFormatter);
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
	public List<Formatter> getFormatters() {
		return formattersList;
	}
	
}
