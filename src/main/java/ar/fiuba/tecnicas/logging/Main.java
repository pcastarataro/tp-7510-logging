package ar.fiuba.tecnicas.logging;
import ar.fiuba.tecnicas.logging.LoggerFactory;
import ar.fiuba.tecnicas.logging.level.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerFactory factory=LoggerFactory.getInstance();
		Logger logger=factory.createLogger("config.txt"); 
		logger.log(new ConcreteLevel(LevelPriority.OFF), "probando mostrar mensaje");
		logger.log(new ConcreteLevel(LevelPriority.DEBUG), "probando otro mensaje");
		logger.log(new ConcreteLevel(LevelPriority.ERROR), "probando ultimo mensaje");
	}

}
