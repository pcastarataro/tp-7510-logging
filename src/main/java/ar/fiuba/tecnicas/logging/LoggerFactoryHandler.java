package ar.fiuba.tecnicas.logging;

public interface LoggerFactoryHandler {
	public abstract LoggerFactoryHandler getNext();
	public abstract Logger createLogger(String loggerName);
	public abstract void setNext(LoggerFactoryHandler nextHandler);
}
