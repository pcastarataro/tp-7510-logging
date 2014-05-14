package ar.fiuba.tecnicas.logging.context;

/**
 * This interface is used to abstract all the information about the context in which the method was called.
 * @author pablo
 *
 */
public interface ExecutionContext {
	
	/**
	 * 
	 * @return the file name
	 */
	public String getFileName();
	
	/**
	 * 
	 * @return the method name
	 */
	public String getMethodName();
	
	/**
	 * 
	 * @return the class name
	 */
	public String getClassName();
	
	/**
	 * 
	 * @return the line number
	 */
	public int getLineNumber();
	
	/**
	 * 
	 * @return the thread id
	 */
	public long getThreadID();
	
	/**
	 * 
	 * @return the thread name
	 */
	public String getThreadName();

}
