package edu.drexel.samyam;

public class UpperCaseMain {

	public static void main(String args[]) {
		// Create a pipe between a Generator and Filter
		Pipe pipe = new PipeImpl();

		// create the Generator and Filter
		Filter generator = new Generator(pipe, null);
		Filter caseConverter = new UpperCaseConverter(pipe, null);

		// start the generator and the filter
		generator.start();
		caseConverter.start();
		
		
		
		
		
	}
}
