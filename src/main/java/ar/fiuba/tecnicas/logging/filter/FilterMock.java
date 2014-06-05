package ar.fiuba.tecnicas.logging.filter;

import ar.fiuba.tecnicas.logging.format.LogParameter;

public class FilterMock implements Filter{

	public FilterMock(){}
	
	@Override
	public void setConfigurationString(String configurationStr)
			throws InvalidConfigurationStringException {
		//System.out.println(configurationStr);
	}

	@Override
	public void testShouldLog(LogParameter logParams)
			throws FilterNotMatchException {
		
	}
	
}
