package com.drexel.samyam;

import java.awt.event.ActionEvent;

public class WaitingNextOperand extends State {

	public WaitingNextOperand(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		String input = calculatorContext.getValue();

		if (operators.contains(input) || input.equals(EQUALS)) {
			Error errorState = new Error(calculatorContext);
			calculatorContext.setPrevState(this);
			calculatorContext.setState(errorState);
			errorState.performAction();

		} else if (digits.contains(input)) {
			calculatorContext.addSecondOperand(calculatorContext.getValue());
			calculatorContext.setDisplayString(calculatorContext.getValue());
			calculatorContext.setState(new GetSecondOperand(calculatorContext));
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
					calculatorContext.getDisplayString().toString()));
		} else if (input.equalsIgnoreCase(RESET)) {
			reset();
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
		}
	}
}
