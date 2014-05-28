package ar.fiuba.tecnicas.logging.log;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements OutputFactory and returns the correct Output depending on the outputString.
 * This class has the responsibility of known all the kinds of output classes and dispatch them.
 * In case of a new kind of Output class, we have to add this to the List.
 * @author pablo
 *
 */
public class ConcreteOutputFactory implements OutputFactory {

	private List<String> outputsClassNames;
	
	public ConcreteOutputFactory() {
		loadOutputClass();
	}
	
	public Output makeOutputForOutputString(String outputString) 
			throws IllegalOutputPatternException {
		
		Output output;
		
		for (String className : outputsClassNames) {
			try {
				output = (Output) Class.forName(className).newInstance();
				output.setOutputString(outputString);
				return output;
			} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			} catch (ClassNotFoundException e) {
			} catch (IllegalOutputPatternException e) {
			}
		}
		throw new IllegalOutputPatternException();
	}

	private void loadOutputClass() {
		outputsClassNames = new ArrayList<String>();
		outputsClassNames.add("ar.fiuba.tecnicas.logging.log.ConsoleOutput");
		outputsClassNames.add("ar.fiuba.tecnicas.logging.log.FileOutput");
	}
}
