package ar.fiuba.tecnicas.logging.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.fiuba.tecnicas.logging.format.IllegalDatePatternException;

/**
 * This class is an implementation for Formatter that allows to make the format of all the dates with the patters
 *  allowed by SimpleDateFormat.
 * @author pcastarataro
 *
 */
public class DateFormatter extends AbstractFormatter {

	private int initialDatePosition;
	private int finalDatePosition;
	
	private final String initialDatePattern = "%d{";
	private final String finalDatePattern = "}";
	
	/**
	 * Replace all the occurrences of date pattern with the current date.
	 */
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		Date date = (Date)parameters.getParameterNamed("date");
		
		findNextPatternPositions(baseFormat);
		
		while(patterFinded()) {
			initialDatePosition += initialDatePattern.length();
			String datePattern = extractNextPattern(baseFormat);
			
			try {
				DateFormat dateFormatter = new SimpleDateFormat(datePattern);
				String formattedDate = dateFormatter.format(date);
				baseFormat = replacePatternsOcurrencesWithFormattedString(
						baseFormat, datePattern, formattedDate);
			}
			catch(IllegalArgumentException ex) {
				System.err.println("Date patter '" + datePattern + "' is not valid");
				baseFormat = replacePatternsOcurrencesWithFormattedString(
						baseFormat, datePattern, "");
				throw new IllegalDatePatternException();
			}
			findNextPatternPositions(baseFormat);
		}
		return baseFormat;
	}

	private String replacePatternsOcurrencesWithFormattedString(
			String baseFormat, String datePattern, String formattedDate) {
		baseFormat = baseFormat.replace(initialDatePattern + datePattern + 
				finalDatePattern, formattedDate);
		return baseFormat;
	}

	private String extractNextPattern(String baseFormat) {
		String datePattern = baseFormat.substring(initialDatePosition, finalDatePosition);
		return datePattern;
	}

	private void findNextPatternPositions(String baseFormat) {
		initialDatePosition = baseFormat.indexOf(initialDatePattern);
		finalDatePosition = baseFormat.indexOf(finalDatePattern);
	}
	
	private boolean patterFinded() {
		return initialDatePosition != -1 && finalDatePosition != -1;
	}

}
