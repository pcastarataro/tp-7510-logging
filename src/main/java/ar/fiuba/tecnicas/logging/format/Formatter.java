package ar.fiuba.tecnicas.logging.format;


public interface Formatter {

	public String preProcessFormat(String baseFormat, LogParameter parameters);
	
	public String postProcessFormat(String baseFormat, LogParameter parameters);
	
}
