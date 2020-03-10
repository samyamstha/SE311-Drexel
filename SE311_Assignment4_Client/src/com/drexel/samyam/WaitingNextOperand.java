package com.drexel.samyam;

import java.awt.event.ActionEvent;

public class WaitingNextOperand extends State {

	public WaitingNextOperand(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		System.out.println("WaitingNextOperand");

		String input = calculatorContext.getValue();

		if (operators.contains(input) || input.equals(EQUALS)) {
			// TODO get to the error state
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
