package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of ThreadName pattern in an string.
 * @author pcastarataro
 *
 */
public class ThreadNameFormatter extends AbstractFormatter {

	/**
	 * This method replace all the occurrences of Thread Name pattern with the real Thread Name.
	 */
	public String preProcessFormat(String baseFormat, ILogParameter parameters) {
		IExecutionContext executionContext = (IExecutionContext)parameters.getParameterNamed("executionContext");
		return baseFormat.replace("%t", executionContext.getThreadName());
	}

}
