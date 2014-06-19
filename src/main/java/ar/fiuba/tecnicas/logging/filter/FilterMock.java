package ar.fiuba.tecnicas.logging.filter;

import ar.fiuba.tecnicas.logging.format.ILogParameter;

public class FilterMock implements IFilter{

	public FilterMock(){}
	private String configurationStr;
	
	@Override
	public void setConfigurationString(String configurationStr)
			throws InvalidConfigurationStringException {
		this.configurationStr=configurationStr;
		//System.out.println(configurationStr);
	}

	@Override
	public void testShouldLog(ILogParameter logParams)
			throws FilterNotMatchException {
		
	}
	
	public String getAsXml(){
		String xml="<customFilter class=\""+this.getClass().getName()+"\">";
		xml+=this.configurationStr;
		xml+="</customFilter>";
		return xml;
	}
	
}
