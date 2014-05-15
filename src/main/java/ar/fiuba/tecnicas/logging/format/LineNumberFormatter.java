package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of LineNumber pattern in an string.
 * @author pcastarataro
 *
 */
public class LineNumberFormatter extends AbstractFormatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		ExecutionContext executionContext = (ExecutionContext)parameters.getParameterNamed("executionContext");
		return baseFormat.replace("%L", String.valueOf(executionContext.getLineNumber()));
	}

}
