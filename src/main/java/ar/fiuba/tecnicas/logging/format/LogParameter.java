package ar.fiuba.tecnicas.logging.format;

import java.util.Date;
import java.util.HashMap;

import ar.fiuba.tecnicas.logging.context.IExecutionContext;
import ar.fiuba.tecnicas.logging.level.ILevel;

/**
 * This class is an implementation of the interface LogParameter. It allows to share parameters between any log and any format.
 * @author pcastarataro
 *
 */
public class LogParameter implements ILogParameter{
	
	private HashMap<String, Object> parameters;
	
	/**
	 * Contructor: create an instance of ConcreteLogParameter that allows to share level, message, executionContext, delimiter, date
	 * @param level
	 * @param message
	 * @param executionContext
	 * @param delimiter
	 * @param date
	 */
	public LogParameter(ILevel level, String message, 
			IExecutionContext executionContext, 
			String delimiter , Date date, String loggerName) {
		parameters = new HashMap<String, Object>();
		parameters.put("level", level);
		parameters.put("message", message);
		parameters.put("executionContext", executionContext);
		parameters.put("delimiter", delimiter);
		parameters.put("date", date);
		parameters.put("loggerName", loggerName);
		
	}
	
	/**
	 * Return the value of the parameter named 'parameterName'. In case of invalid name
	 * throws ParameterNotFoundException.
	 */
	public Object getParameterNamed(String parameterName) throws ParameterNotFoundException {
			Object parameter = parameters.get(parameterName);
			if(parameter == null)
				throw new ParameterNotFoundException();
			return parameter;
	}
	
}
