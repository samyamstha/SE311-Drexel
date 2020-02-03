package edu.drexel.samyam;

import java.util.Scanner;

public class MasterControl {

	private static int CONSOLE_IO = 1;
	private static int FILE_IO = 2;
	private static int AFTER_INPUT = 1;
	private static int AFTER_CIRCULAR_SHIFT = 2;
	private static int AFTER_ALPHABETIZER = 3;

	private static Input input;
	private static Output output;
	private static Filter circularShift;
	private static Filter alphabetize;
	private static Filter caseConverter;

	public static void main(String[] args) {

		Pipe in_cs = new PipeImpl(); // pipe between input and circular shift
		Pipe cs_al = new PipeImpl(); // pipe between circular shift and alphabetizer
		Pipe al_ou = new PipeImpl(); // pipe between alphabetizer and output
		Pipe uc = new PipeImpl(); // pipe for upper case converter

		if (getIOChoice() == CONSOLE_IO) {
			
			int location = getUpperCasePipeLocation();
			if(location == 1) {
				input = new ConsoleInput(null, in_cs);
				caseConverter = new UpperCaseConverter(in_cs, uc);
				circularShift = new CircularShift(uc, cs_al);
				alphabetize = new Alphabetize(cs_al, al_ou);
				output = new FileOutput(al_ou, null);
				
			} else if(location == 2) {
				input = new ConsoleInput(null, in_cs);
				circularShift = new CircularShift(in_cs, uc);
				caseConverter = new UpperCaseConverter(uc, cs_al);
				alphabetize = new Alphabetize(cs_al, al_ou);
				output = new FileOutput(al_ou, null);
			} else {
				input = new ConsoleInput(null, in_cs);
				circularShift = new CircularShift(in_cs, cs_al);
				alphabetize = new Alphabetize(cs_al, uc);
				caseConverter = new UpperCaseConverter(uc, al_ou);
				output = new FileOutput(al_ou, null);
			}
			
			input.start();
			caseConverter.start();
			circularShift.start();
			alphabetize.start();
			output.start();
			
		} else {
			int location = getUpperCasePipeLocation();
			if(location == 1) {
				input = new FileInput(null, in_cs);
				caseConverter = new UpperCaseConverter(in_cs, uc);
				circularShift = new CircularShift(uc, cs_al);
				alphabetize = new Alphabetize(cs_al, al_ou);
				output = new FileOutput(al_ou, null);
				
			} else if(location == 2) {
				input = new FileInput(null, in_cs);
				circularShift = new CircularShift(in_cs, uc);
				caseConverter = new UpperCaseConverter(uc, cs_al);
				alphabetize = new Alphabetize(cs_al, al_ou);
				output = new FileOutput(al_ou, null);
			} else {
				input = new FileInput(null, in_cs);
				circularShift = new CircularShift(in_cs, cs_al);
				alphabetize = new Alphabetize(cs_al, uc);
				caseConverter = new UpperCaseConverter(uc, al_ou);
				output = new FileOutput(al_ou, null);
			}
			
			input.start();
			caseConverter.start();
			circularShift.start();
			alphabetize.start();
			output.start();


		}

	}

	private static int getUpperCasePipeLocation() {
		String prompt = "Please enter the location for uppercase converter:\n" + AFTER_INPUT + ". After Input\n"
				+ AFTER_CIRCULAR_SHIFT + ". After Circular Shift\n" + AFTER_ALPHABETIZER + ". After Alphabetizer";
		int user_IO_preference;

		input = new ConsoleInput(null, null);
		System.out.println(prompt);

		do {
			System.out.println("\nPlease make sure to enter a valid input");
			user_IO_preference = ((ConsoleInput) input).getIntInput();
		} while (!(user_IO_preference > 0 && user_IO_preference < 4));

		return user_IO_preference;
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
