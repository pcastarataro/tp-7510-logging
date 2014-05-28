package ar.fiuba.tecnicas.logging.log;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import junit.framework.TestCase;

public class ExcecutionContextTest extends TestCase {

	Thread thread = Thread.currentThread();
	
	private ExecutionContext getCurrentContext(){
		return new LoggingExecutionContext();
	}
	
	public void testMethodNameFromContextOk(){
		 String methodName = this.getCurrentContext().getMethodName();
		 
		 assertEquals(methodName, "testMethodNameFromContextOk");
	}
	
	public void testMethodNameFromContextError(){
		 String methodName = this.getCurrentContext().getMethodName();
		 
		 assertNotSame(methodName, "falseMethodName");
	}
	
	public void testThreadNameFromContextOk(){
		 String threadName = this.getCurrentContext().getThreadName();
		 
		 assertEquals(threadName, thread.getName());
	}
	
	public void testThreadNameFromContextError(){
		 String threadName = this.getCurrentContext().getThreadName();
		 
		 assertNotSame(threadName, "falseThreadName");
	}
	
	public void testThreadIdFromContextOk(){
		 long threadId = this.getCurrentContext().getThreadID();
		 
		 assertSame(threadId, thread.getId());
	}
	
	public void testThreadIdFromContextError(){
		long threadId = this.getCurrentContext().getThreadID();
		 
		 assertNotSame(threadId, -4);
	}
	
	public void testClassNameFromContextOk(){
		String className = this.getCurrentContext().getClassName();
		 
		 assertEquals(className, "ar.fiuba.tecnicas.logging.log.ExcecutionContextTest");
	}
	
	public void testClassNameFromContextError(){
		String className = this.getCurrentContext().getClassName();
		 
		 assertNotSame(className, "ar.fiuba.tecnicas.logging.log.falseClassName");
	}
	
	public void testFileNameFromContextOk(){
		String fileName = this.getCurrentContext().getFileName();
		 
		 assertEquals(fileName, "ExcecutionContextTest.java");
	}
	
	public void testFileNameFromContextError(){
		String fileName = this.getCurrentContext().getFileName();
		 
		 assertNotSame(fileName, "falseFileName.java");
	}
}
