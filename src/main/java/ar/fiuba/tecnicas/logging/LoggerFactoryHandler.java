package ar.fiuba.tecnicas.logging;

public interface LoggerFactoryHandler {
	public abstract LoggerFactoryHandler getNext();
	public abstract ILogger createLogger(String loggerName);
	public abstract void setNext(LoggerFactoryHandler nextHandler);
	public abstract void setPropertiesPath(String path);
}
