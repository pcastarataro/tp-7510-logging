package ar.fiuba.tecnicas.logging.filter;

import ar.fiuba.tecnicas.logging.format.ILogParameter;

public class FilterMock implements IFilter{

	public FilterMock(){}
	
	@Override
	public void setConfigurationString(String configurationStr)
			throws InvalidConfigurationStringException {
		//System.out.println(configurationStr);
	}

	@Override
	public void testShouldLog(ILogParameter logParams)
			throws FilterNotMatchException {
		
	}
	
}
