package ar.fiuba.tecnicas.logging.format;

import java.util.Date;
import java.util.HashMap;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.level.Level;

public class ConcreteLogParameter implements LogParameter{
	
	private HashMap<String, Object> parameters;
	
	public ConcreteLogParameter(Level level, String message, 
			ExecutionContext executionContext, 
			String delimiter , Date date) {
		parameters = new HashMap<String, Object>();
		parameters.put("level", level);
		parameters.put("message", message);
		parameters.put("executionContext", executionContext);
		parameters.put("delimiter", delimiter);
		parameters.put("date", date);
		
	}
	
	public Object getParameterNamed(String parameterName) throws ParameterNotFoundException {
			Object parameter = parameters.get(parameterName);
			if(parameter == null)
				throw new ParameterNotFoundException();
			return parameter;
	}
	
}
