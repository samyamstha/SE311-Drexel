package com.drexel.samyam;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Error extends State {

	public Error(CalculatorContext calculatorContext) {
		super(calculatorContext);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performAction() {
		System.out.println("Error St!ate");

		Object[] options = { "Discard", "Reset" };
		int userChoice = JOptionPane.showOptionDialog(null, "Please select an option.", "Error!",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
				options, // the titles of buttons
				options[0]); // default button title
		System.out.println("User chose: " + userChoice);
		
		if(userChoice == 1) {
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
			reset();
		} else if (userChoice == 0) {
			calculatorContext.setState(calculatorContext.getPrevState());
		}
	}
}
