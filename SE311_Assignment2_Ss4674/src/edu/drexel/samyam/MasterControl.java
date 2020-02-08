package edu.drexel.samyam;


public class MasterControl {

	private static int CONSOLE_IO = 1;
	private static int FILE_IO = 2;
	private static int AFTER_INPUT = 1;
	private static int AFTER_CIRCULAR_SHIFT = 2;
	private static int AFTER_ALPHABETIZER = 3;

	private static Filter input;
	private static Filter output;
	private static Filter circularShift;
	private static Filter alphabetize;
	private static Filter caseConverter;
	private static Pipe input_pipe = new PipeImpl();
	private static Pipe circularShift_pipe = new PipeImpl();
	private static Pipe alphabetizer_pipe = new PipeImpl();
	private static Pipe upperCase_pipe = new PipeImpl();
	private static int location = 0;
	private static String outputFile;

	public static void main(String[] args) {

		String prompt = "Please provide the correct location argument for uppercase converter as follows:\n"
				+ "Provide " + AFTER_INPUT + " for After Input\n" + "Provide " + AFTER_CIRCULAR_SHIFT
				+ " for After Circular Shift\n" + "Provide " + AFTER_ALPHABETIZER + " for After Alphabetizer\n"
				+ "\nPlease provide the name of the output file followed by the location argument."
				+ "\nExample: <Location> <outputFile>";
		try {
			if (args.length != 2) {
				throw new Exception();
			}
			location = Integer.parseInt(args[0]);
			outputFile = args[1];
		} catch (Exception e) {
			System.out.println("Required args not provided!\nSystem terminated!\n");
			System.out.println(prompt);
			System.exit(0);
		}

		if (location < 1 && location > 3) {
			System.out.println(prompt);
		}

		if (getIOChoice() == CONSOLE_IO) {
			input = new ConsoleInput(null, input_pipe);
			runIt(input);

		} else {
			input = new FileInput(null, input_pipe);
			runIt(input);
		}

	}

	private static void runIt(Filter input) {
		if (location == 1) {
			caseConverter = new UpperCaseConverter(input_pipe, upperCase_pipe);
			output = new FileOutput(upperCase_pipe, null, outputFile);

			input.start();
			caseConverter.start();
			output.start();

		} else if (location == 2) {
			circularShift = new CircularShift(input_pipe, circularShift_pipe);
			caseConverter = new UpperCaseConverter(circularShift_pipe, upperCase_pipe);
			output = new FileOutput(upperCase_pipe, null, outputFile);

			input.start();
			caseConverter.start();
			circularShift.start();
			output.start();

		} else {
			circularShift = new CircularShift(input_pipe, circularShift_pipe);
			alphabetize = new Alphabetize(circularShift_pipe, alphabetizer_pipe);
			caseConverter = new UpperCaseConverter(alphabetizer_pipe, upperCase_pipe);
			output = new FileOutput(upperCase_pipe, null, outputFile);

			input.start();
			caseConverter.start();
			circularShift.start();
			alphabetize.start();
			output.start();
		}
	}

	private static int getIOChoice() {

		String prompt = "Please enter your choice for IO operation:\n" + CONSOLE_IO + ". Console Input\n" + FILE_IO
				+ ". File";
		int user_IO_preference;

		input = new ConsoleInput(null, null);
		System.out.println(prompt);

		do {
			System.out.println("\nPlease make sure to enter a valid input");
			user_IO_preference = ((ConsoleInput) input).getIntInput();
		} while (!(user_IO_preference > 0 && user_IO_preference < 3));

		return user_IO_preference;

	}

}
