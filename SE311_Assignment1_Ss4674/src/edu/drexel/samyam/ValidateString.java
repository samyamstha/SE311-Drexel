package edu.drexel.samyam;

import java.util.InputMismatchException;

public class ValidateString extends Validate {

	@Override
	public boolean validateInput(String input) {

		try {
			if (input.equals("") || input.equals(" ")) {
				return false;
			}
			
		} catch (InputMismatchException ime) {
			return false;
		}
		return true;
	}

}
