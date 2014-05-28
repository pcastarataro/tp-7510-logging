package ar.fiuba.tecnicas.logging.context;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;

/**
 * This class is an implementation of ExecutionContext that allow to retrieve all the information of the context when the method of logging was called.
 * @author pcastarataro
 *
 */
public class LoggingExecutionContext implements ExecutionContext {

	private String fileName;
	private String methodName;
	private String className;
	private int lineNumber;
	private long threadID;
	private String threadName;
	
	private static final int levelsUp = 6;
	
	protected void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	protected void setClassName(String className) {
		this.className = className;
	}

	protected void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	protected void setThreadID(long threadID) {
		this.threadID = threadID;
	}

	protected void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
	/**
	 * New LoggingExecutionContext instance with all the information about the context execution 
	 */
	public LoggingExecutionContext() {
		Thread thread = Thread.currentThread();
		StackTraceElement stackTraceElement = thread.getStackTrace()[levelsUp];
		setFileName(stackTraceElement.getFileName());
		setMethodName(stackTraceElement.getMethodName());
		setClassName(stackTraceElement.getClassName());
		setLineNumber(stackTraceElement.getLineNumber());
		setThreadID(thread.getId());
		setThreadName(thread.getName());
	}
	
	/**
	 * Return the filename
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Returns method name
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * Returns Class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Returns the line number
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Returns the thread ID
	 */
	public long getThreadID() {
		return threadID;
	}

	/**
	 * Returns the thread Name
	 */
	public String getThreadName() {
		return threadName;
	}
	
}
