
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.fiuba.tecnicas.logging.log.StaticListOutput;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		
//		Logger logger = LoggerFactory.getLogger("Main");
//	    logger.info("Hello World"); 
//	    logger.debug("probando otro mensaje");
//	    logger.error("probando ultimo mensaje");
//	    Main.logSomething("aaa");
//	    
//	    logger.debug("con exception ", new Exception());
//	   
//	    logger.error("{}-{}","Hola","Mundo");
//	    logger.error("{}-{}","Hola");
//	    
//	    try {
//	    	throw new RuntimeException();
//	    }
//	    catch(RuntimeException e) {
//	    	logger.error("EX: ", e);
//	    }
	    
	    Logger logger1 = LoggerFactory.getLogger("logger1");
	    Logger logger2 = LoggerFactory.getLogger("logger2");
	    Logger logger3 = LoggerFactory.getLogger("logger3");
	    
	    logger1.info("Hello World");
	    logger1.info("Hola Mundo");
	    logger1.info("Hallo Welt");
	    
	    logger2.info("tp no deberia loguearse");
	    logger2.debug("tp deberia loguearse");
	    
	    logger3.trace("no debería loguearse..");
	    logger3.warn("esto deberia logguearse con excepcion", new NullPointerException());
	    logger3.error("esto deberia logguearse tambien..."); //No es parte de la Interfaz de SLF4J
	    
	    
	    System.out.println("");
	    System.out.println("Cantidad de mensajes Logueados en Clase Estatica : " + StaticListOutput.messageList.size());
	    System.out.println(StaticListOutput.messageList.get(0));
    
	}
	
	public static void logSomething(String a) {
		Logger logger = LoggerFactory.getLogger(Main.class);
	    logger.error(a);
	}

}
