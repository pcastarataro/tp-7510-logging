package ar.fiuba.tecnicas.logging.format;

/**
 * This interface abstract the functionality of pass parameters between the log and all the kinds of formats.
 * @author pcastarataro
 *
 */
public interface LogParameter {

	/**
	 * This method returns the parameters named as the parameter received.
	 * @param parameterName: the name of the parameter that you want to obtain
	 * @return the value of the parameter searched.
	 * @throws ParameterNotFoundException if the parameter doesn't exists.
	 */
	public Object getParameterNamed(String parameterName) throws ParameterNotFoundException;
	
}
