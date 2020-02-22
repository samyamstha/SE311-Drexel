package edu.drexel.samyam;

import java.util.Scanner;

public class MasterControl {

	private static int CONSOLE_INPUT = 1;
	private static int FILE_INPUT = 2;

	private static Input input;
	private static LineStorage lineStorage = new LineStorage();
	private static ConsoleOutput output = new ConsoleOutput(lineStorage);
	private static CircularShift circularShift = new CircularShift(lineStorage);
	private static Alphabetize alphabetize = new Alphabetize(lineStorage);
	private static InteractiveInput interactiveInput = new InteractiveInput(lineStorage, new ConsoleInput(), alphabetize, output);
	
	public static void main(String[] args) {
		getInputChoice();

//		get line input
		input.getInput();
		
		interactiveInput.getInput();
		
	
//		perform circular shift
		// circularShift.setup();
//		alphabetize
		// alphabetize.alphabetizeLines();
//		display output
		// output.printLines();

	}

	private static void getInputChoice() {

		String prompt = "Please enter your choice for input operation:\n" + CONSOLE_INPUT + ". Console\n" + FILE_INPUT
				+ ". File\n";
		int user_preference;

		input = new ConsoleInput();
		System.out.println(prompt);

		do {
			System.out.println("\nPlease make sure to enter a valid input");
			user_preference = ((ConsoleInput) input).getIntInput();
		} while (!(user_preference > 0 && user_preference < 3));

		if (user_preference == 1) {
			input = new ConsoleInput(lineStorage);
		} else if (user_preference == 2) {
			input = new FileInput(lineStorage);
		}
	}

}
