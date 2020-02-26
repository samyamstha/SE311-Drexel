package edu.drexel.samyam;

import java.util.Scanner;

public class MasterControl {

	private static int CONSOLE_IO = 1;
	private static int FILE_IO = 2;
	
	private static Input input;
	private static Output output;
	
	
	public static void main(String[] args) {
		
		LineStorage lineStorage = new LineStorage();
		CircularShift circularShift = new CircularShift(lineStorage);
		Alphabetize alphabetize = new Alphabetize(lineStorage);

		if (getIOChoice() == CONSOLE_IO) {
			output = new ConsoleOutput(lineStorage);
			input = new ConsoleInput(lineStorage);
			
		} else {
			output = new FileOutput(lineStorage);
			input = new FileInput(lineStorage);
			
		}

//		get line input
		input.getInput();
//		perform circular shift
		circularShift.setup();
//		alphabetize
		alphabetize.alphabetizeLines();
//		display output
		output.printLines();

	}

	private static int getIOChoice() {

		String prompt = "Please enter your choice for IO operation:\n" + CONSOLE_IO + ". Console\n" + FILE_IO + ". File";
		int user_IO_preference;

		input = new ConsoleInput();
		System.out.println(prompt);

		do {
			System.out.println("\nPlease make sure to enter a valid input");
			user_IO_preference = ((ConsoleInput) input).getIntInput();
		} while (!(user_IO_preference > 0 && user_IO_preference < 3));

		return user_IO_preference;

	}

}
