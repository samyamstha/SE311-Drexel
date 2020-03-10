package com.drexel.samyam;

import java.awt.event.ActionEvent;

public class Calculate extends State {

	public Calculate(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		System.out.println("Calculate State");
		String input = calculatorContext.getValue();

		if (operators.contains(input) || input.equals(EQUALS) || input.equals(RESET)) {
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
			reset();
		} else if (digits.contains(input)) {
			reset();
			State state = new GetFirstOperand(calculatorContext);
			calculatorContext.setState(state);
			state.performAction();
//			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
			
		}
	}

}
