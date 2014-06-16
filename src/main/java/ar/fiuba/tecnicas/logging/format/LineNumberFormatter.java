package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of LineNumber pattern in an string.
 * @author pcastarataro
 *
 */
public class LineNumberFormatter extends AbstractFormatter {

	/**
	 * Replace all the occurrences of Line number pattern with the current Line.
	 */
	public String preProcessFormat(String baseFormat, ILogParameter parameters) {
		IExecutionContext executionContext = (IExecutionContext)parameters.getParameterNamed("executionContext");
		return baseFormat.replace("%L", String.valueOf(executionContext.getLineNumber()));
	}

}
