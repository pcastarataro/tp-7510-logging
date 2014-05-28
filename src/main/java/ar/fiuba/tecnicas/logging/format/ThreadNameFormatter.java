package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of ThreadName pattern in an string.
 * @author pcastarataro
 *
 */
public class ThreadNameFormatter extends AbstractFormatter {

	/**
	 * This method replace all the occurrences of Thread Name pattern with the real Thread Name.
	 */
	public String preProcessFormat(String baseFormat, LogParameter parameters) {
		ExecutionContext executionContext = (ExecutionContext)parameters.getParameterNamed("executionContext");
		return baseFormat.replace("%t", executionContext.getThreadName());
	}

}
