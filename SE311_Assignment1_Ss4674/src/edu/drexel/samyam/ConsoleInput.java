package edu.drexel.samyam;

import java.util.Scanner;

public class ConsoleInput extends Input {

	private Scanner scan;

	public ConsoleInput() {
		scan = new Scanner(System.in);
	}

	public ConsoleInput(LineStorage lineStorage) {
		scan = new Scanner(System.in);

		this.lineStorage = lineStorage;

	}

	@Override
	public void getInput() {

		getNumOfLines();

	}

	public int getIntInput() {
		String input;
		validate = new ValidateInt();
		input = scan.nextLine().trim();

		if (validate.validateInput(input)) {
			return Integer.parseInt(input);
		}
		return -1;
	}

	private void getNumOfLines() {
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
		validate = new ValidateString();

		for (int i = 0; i < Integer.parseInt(numOfLines); i++) {
			valid = false;
			System.out.println("Please enter the line number: " + Integer.toString(i));
			String input = scan.nextLine().trim();
			while (!valid) {
				if (validate.validateInput(input)) {
					valid = true;
				} else {
					System.out.println("Please enter a valid line");
					input = scan.nextLine().trim();
				}
			}
			lineStorage.addLine(input);
		}
	}

}
