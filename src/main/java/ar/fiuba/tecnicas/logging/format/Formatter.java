package ar.fiuba.tecnicas.logging.format;

/**
 * This interface abstract all the logic necessary to proccess the format.
 * @author pcastarataro
 *
 */
public interface Formatter {

	/**
	 * This method make the preprocess necessary to format the string received in baseFormat using the LogParameters recieved. 
	 * @param baseFormat
	 * @param parameters
	 * @return the formatted preprocessed string.
	 */
	public String preProcessFormat(String baseFormat, LogParameter parameters);
	
	/**
	 * This method make the postprocess necessary to format the string received in baseFormat using the LogParameters recieved. 
	 * @param baseFormat
	 * @param parameters
	 * @return the formatted postprocess string.
	 */
	public String postProcessFormat(String baseFormat, LogParameter parameters);
	
}
