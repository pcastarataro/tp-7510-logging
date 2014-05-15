package ar.fiuba.tecnicas.logging;
import ar.fiuba.tecnicas.logging.LoggerFactory;
import ar.fiuba.tecnicas.logging.level.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerFactory factory=LoggerFactory.newInstance();
		Logger logger=factory.createLogger("config.txt"); 
		logger.log(OffLevel.getInstance(), "probando mostrar mensaje");
		logger.log(FatalLevel.getInstance(), "probando otro mensaje");
		logger.log(ErrorLevel.getInstance(), "probando ultimo mensaje");
	}

}
