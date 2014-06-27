package ar.fiuba.tecnicas.logging.filter;

import ar.fiuba.tecnicas.logging.format.ILogParameter;
import ar.fiuba.tecnicas.logging.level.Level;

public class LevelFilter implements IFilter{

	public LevelFilter(){}

	private String levelName;
	
	@Override
	public void setConfigurationString(String configurationStr)
			throws InvalidConfigurationStringException {
		levelName = configurationStr;
	}

	@Override
	public void testShouldLog(ILogParameter logParams)
			throws FilterNotMatchException {
		
		Level level = (Level)logParams.getParameterNamed("level");
		
		if (!level.getName().contains(levelName)){
			throw new FilterNotMatchException();
		}
		
	}
	
	public String getAsXml(){
		String xml="<customFilter class=\""+this.getClass().getName()+"\">";
		xml+=levelName;
		xml+="</customFilter>";
		return xml;
	}
	
}