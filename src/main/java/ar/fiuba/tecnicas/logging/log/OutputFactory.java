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
public class OutputFactory implements IOutputFactory {
	private static OutputFactory factory=new OutputFactory();
	private List<String> outputsClassNames;
	
	/**
	 * Create a new OutputFactory.
	 */
	public OutputFactory() {
		loadOutputClass();
	}
	
	public static OutputFactory getInstance(){
		return OutputFactory.factory;
	}
	
	/**
	 * Make a new Output depending on the output string
	 */
	public IOutput makeOutputForOutputString(String outputString) 
			throws IllegalOutputPatternException {
		
		IOutput output;
		
		for (String className : outputsClassNames) {
			try {
				output = (IOutput) Class.forName(className).newInstance();
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
		outputsClassNames.add(ConsoleOutput.class.getName());
		outputsClassNames.add(FileOutput.class.getName());
		outputsClassNames.add(StaticListOutput.class.getName());
	}
}
