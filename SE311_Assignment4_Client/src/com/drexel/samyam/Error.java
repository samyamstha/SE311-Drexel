package com.drexel.samyam;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Error extends State {

	private String DIALOG_PROMPT = "Please select an option.";
	private String DIALOG_TITLE = "Error!";

	public Error(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		// the titles of buttons
		Object[] options = { "Discard", "Reset" };
		int userChoice = JOptionPane.showOptionDialog(null, DIALOG_PROMPT, DIALOG_TITLE, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]); // default button
																			// title
		if (userChoice == 1) {
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
			reset();
		} else if (userChoice == 0) {
			calculatorContext.setState(calculatorContext.getPrevState());
		}
	}
}
