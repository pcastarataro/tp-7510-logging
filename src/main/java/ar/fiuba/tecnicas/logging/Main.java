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
		Logger logger1=factory.createLogger("logger1"); 
		logger1.log(LevelPriority.OFF, "probando mostrar mensaje");
		logger1.log(LevelPriority.DEBUG, "probando otro mensaje");
		logger1.log(LevelPriority.WARN, "probando ultimo mensaje");
		//propertie
		Logger logger2=factory.createLogger("logger2"); 
		logger2.log(LevelPriority.OFF, "probando mostrar mensaje");
		logger2.log(LevelPriority.DEBUG, "probando otro mensaje");
		logger2.log(LevelPriority.WARN, "probando ultimo mensaje");
		
		Logger logger3=factory.createLogger("logger3"); 
		logger3.log(LevelPriority.OFF, "probando mostrar mensaje");
		logger3.log(LevelPriority.DEBUG, "probando otro mensaje");
		logger3.log(LevelPriority.WARN, "probando ultimo mensaje");
		//default
		Logger logger4=factory.createLogger("logger4"); 
		logger4.log(LevelPriority.OFF, "probando mostrar mensaje");
		logger4.log(LevelPriority.DEBUG, "probando otro mensaje");
		logger4.log(LevelPriority.WARN, "probando ultimo mensaje");
	}

}
