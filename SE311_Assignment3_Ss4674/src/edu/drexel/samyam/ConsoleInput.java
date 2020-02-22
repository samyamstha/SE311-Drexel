package edu.drexel.samyam;

import java.util.Scanner;

public class ConsoleInput extends Input {

	public ConsoleInput() {
		super(null);
		scan = new Scanner(System.in);
	}

	public ConsoleInput(LineStorage lineStorage) {
		super(lineStorage);
		scan = new Scanner(System.in);

		this.lineStorage = lineStorage;

	}

	@Override
	public void getInput() {

		int numOfLines = getNumOfLines();
		for (int i = 0; i < numOfLines; i++) {
			String input = getLineInput();
			lineStorage.addLine(input);
		}

	}

	private int getNumOfLines() {
		System.out.println("Enter the number of lines you would like to enter.");
		String numOfLines = scan.nextLine().trim();
		boolean valid = false;
		validate = new ValidateInt();

		while (!valid) {
			if (validate.validateInput(numOfLines) && Integer.parseInt(numOfLines) > 0) {
				valid = true;
			} else {
				System.out.println("Please enter valid value.");
				numOfLines = scan.nextLine().trim();
			}
		}
		return Integer.parseInt(numOfLines);
	}

	public String getLineInput() {

		validate = new ValidateString();
		boolean valid = false;
//		System.out.println("Please enter the line number: " + Integer.toString(i));
		System.out.println("Please enter the line: ");
		String input = scan.nextLine().trim();
		while (!valid) {
			if (validate.validateInput(input)) {
				valid = true;
			} else {
				System.out.println("Please enter a valid line");
				input = scan.nextLine().trim();
			}
		}

		return input;
	}

}
