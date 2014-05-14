package ar.fiuba.tecnicas.logging.format;


public interface LogParameter {

	public Object getParameterNamed(String parameterName) throws ParameterNotFoundException;
	
}
