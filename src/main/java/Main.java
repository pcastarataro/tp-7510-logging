
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		Logger logger = LoggerFactory.getLogger(Main.class);
	    logger.info("Hello World"); 
	    logger.debug("probando otro mensaje");
	    logger.error("probando ultimo mensaje");
	    Main.logSomething("aaa");
	   
	    logger.error("{}-{}","Hola","Mundo");
	    logger.error("{}-{}","Hola");
	    
	    try {
	    	throw new RuntimeException();
	    }
	    catch(RuntimeException e) {
	    	logger.error("EX: ", e);
	    }
	}
	
	public static void logSomething(String a) {
		Logger logger = LoggerFactory.getLogger(Main.class);
	    logger.error(a);
	}

}
