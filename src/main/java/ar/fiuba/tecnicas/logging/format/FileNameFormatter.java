package ar.fiuba.tecnicas.logging.format;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;

/**
 * This class is an implementation of Formatter that allows to format 
 * all the occurrences of file name pattern in the format send.
 * @author pcastarataro
 *
 */
public class FileNameFormatter extends AbstractFormatter {
	
	/**
	 * Replace all the occurrences of file pattern with the name of the file.
	 */
	public String preProcessFormat(String baseFormat, ILogParameter parameters) {
		IExecutionContext executionContext = (IExecutionContext)parameters.getParameterNamed("executionContext");
		return baseFormat.replace("%F", executionContext.getFileName());
	}

}
