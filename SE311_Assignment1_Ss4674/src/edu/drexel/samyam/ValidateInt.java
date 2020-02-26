package edu.drexel.samyam;

public class ValidateInt extends Validate {

	@Override
	public boolean validateInput(String input) {

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
