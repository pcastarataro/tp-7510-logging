package ar.fiuba.tecnicas.logging;
import ar.fiuba.tecnicas.logging.LoggerFactory;
import ar.fiuba.tecnicas.logging.level.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoggerFactory factory=LoggerFactory.getInstance();
		//xml
		//Logger logger=factory.createLogger("logger1"); 
		//propertie
		Logger logger=factory.createLogger("logger2"); 
		//default
		//Logger logger=factory.createLogger("logger4"); 
		logger.log(LevelPriority.OFF, "probando mostrar mensaje");
		logger.log(LevelPriority.DEBUG, "probando otro mensaje");
		logger.log(LevelPriority.ERROR, "probando ultimo mensaje");
	}

}
