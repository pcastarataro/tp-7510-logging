package org.slf4j.impl;

import org.slf4j.helpers.MarkerIgnoringBase;

import ar.fiuba.tecnicas.logging.context.ExecutionContext;
import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.level.LevelPriority;

/**
 * This class is an adapter for slf4j framework.
 *
 */
public class TPLogger extends MarkerIgnoringBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ar.fiuba.tecnicas.logging.Logger logger;
	
	/**
	 * Constructor from ar.fiuba.tecnicas.logging.Logger
	 * @param logger
	 */
	public TPLogger(ar.fiuba.tecnicas.logging.Logger logger) {
		this.logger = logger;
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#getName()
	 */
	@Override
	public String getName() {
		return this.logger.getName();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String)
	 */
	@Override
	public void debug(String msg) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.DEBUG, msg, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object)
	 */
	@Override
	public void debug(String format, Object param) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParam(format, param);
		this.logger.log(LevelPriority.DEBUG, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void debug(String format, Object... params) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.DEBUG, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void debug(String msg, Throwable t) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.DEBUG, msg, t, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void debug(String format, Object arg1, Object arg2) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		Object[] params = {arg1, arg2};
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.DEBUG, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String)
	 */
	@Override
	public void error(String msg) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.ERROR, msg, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object)
	 */
	@Override
	public void error(String format, Object param) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParam(format, param);
		this.logger.log(LevelPriority.ERROR, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void error(String format, Object... params) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.ERROR, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void error(String msg, Throwable t) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.ERROR, msg, t, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void error(String format, Object arg1, Object arg2) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		Object[] params = {arg1, arg2};
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.ERROR, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String)
	 */
	@Override
	public void info(String msg) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.INFO, msg, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object)
	 */
	@Override
	public void info(String format, Object param) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParam(format, param);
		this.logger.log(LevelPriority.INFO, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void info(String format, Object... params) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.INFO, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void info(String msg, Throwable t) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.INFO, msg, t, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void info(String format, Object arg1, Object arg2) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		Object[] params = {arg1, arg2};
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.INFO, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String)
	 */
	@Override
	public void trace(String msg) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.TRACE, msg, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object)
	 */
	@Override
	public void trace(String format, Object param) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParam(format, param);
		this.logger.log(LevelPriority.TRACE, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void trace(String format, Object... param) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParam(format, param);
		this.logger.log(LevelPriority.TRACE, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void trace(String msg, Throwable t) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.TRACE, msg, t, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void trace(String format, Object arg1, Object arg2) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		Object[] params = {arg1, arg2};
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.TRACE, formattedString, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String)
	 */
	@Override
	public void warn(String msg) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.WARN, msg, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object)
	 */
	@Override
	public void warn(String format, Object param) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParam(format, param);
		this.logger.log(LevelPriority.WARN, formattedString, executionContext);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void warn(String format, Object... params) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.WARN, formattedString, executionContext);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void warn(String msg, Throwable t) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		this.logger.log(LevelPriority.WARN, msg, t, executionContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void warn(String format, Object arg1, Object arg2) {
		ExecutionContext executionContext = new LoggingExecutionContext();
		Object[] params = {arg1, arg2};
		String formattedString = createStringFromFormatAndParams(format, params);
		this.logger.log(LevelPriority.WARN, formattedString, executionContext);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#isDebugEnabled()
	 */
	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#isErrorEnabled()
	 */
	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#isInfoEnabled()
	 */
	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#isTraceEnabled()
	 */
	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.slf4j.Logger#isWarnEnabled()
	 */
	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO Manejo de error por cantidad de parametros incorrectos?
	private String createStringFromFormatAndParams(String format, Object[] params) {
		String formattedString = "";
		String[] splittedArray = format.split("\\{\\}");
		for(int i = 0 ; i < splittedArray.length ; i ++) {
			formattedString += splittedArray[i];
			formattedString += params[i].toString();
		}
		return formattedString;
	}
	
	private String createStringFromFormatAndParam(String format, Object param) {
		String replacementString = param.toString();
		String formattedString = format.replace("{}", replacementString);
		return formattedString;
	}

}
