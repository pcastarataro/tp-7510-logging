package ar.fiuba.tecnicas.logging.format;


public abstract class AbstractFormatter implements Formatter {
	
	public String postProcessFormat(String baseFormat, LogParameter parameters) {
		return baseFormat;
	}

}
