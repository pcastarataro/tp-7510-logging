package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;

/**
 * This class implements the formatter for supporting the replacement of all the occurrences of MethodName  pattern in an string.
 * @author pcastarataro
 *
 */
public class MethodNameFormatter extends AbstractFormatter {

	/**
	 * Replace all the occurrences of Method Name pattern with the real name of the method.
	 */
	public String preProcessFormat(String baseFormat, ILogParameter parameters) {
		IExecutionContext executionContext = (IExecutionContext)parameters.getParameterNamed("executionContext");
		return baseFormat.replace("%M", executionContext.getMethodName());
	}

}
