package edu.drexel.samyam;

import java.util.Scanner;

public abstract class Input {

	protected Validate validate;
	protected LineStorage lineStorage;
	protected Scanner scan;

	public Input(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
		scan = new Scanner(System.in);
	}

	abstract void getInput();

	public int getIntInput() {
		String input;
		validate = new ValidateInt();
		input = scan.nextLine().trim();

		if (validate.validateInput(input)) {
			return Integer.parseInt(input);
		}
		return -1;
	}

}
