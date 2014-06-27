package ar.fiuba.tecnicas.logging.filter;

import ar.fiuba.tecnicas.logging.context.LoggingExecutionContext;
import ar.fiuba.tecnicas.logging.format.ILogParameter;

public class OddLineNumberFilter implements IFilter{

		public OddLineNumberFilter(){}

		@Override
		public void setConfigurationString(String configurationStr)
				throws InvalidConfigurationStringException {
		}

		@Override
		public void testShouldLog(ILogParameter logParams)
				throws FilterNotMatchException {
			
			LoggingExecutionContext executionContext = (LoggingExecutionContext)logParams.getParameterNamed("executionContext");
			
			if (executionContext.getLineNumber() % 2 == 0) throw new FilterNotMatchException();
		}
		
		public String getAsXml(){
			String xml="<customFilter class=\""+this.getClass().getName()+"\">";
			xml+="</customFilter>";
			return xml;
		}
		
	}