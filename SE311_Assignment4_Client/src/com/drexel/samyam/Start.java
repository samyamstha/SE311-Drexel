package com.drexel.samyam;

import java.awt.event.ActionEvent;

public class Start extends State {

	public Start(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {

		if (digits.contains(calculatorContext.getValue())) {
			calculatorContext.setState(new GetFirstOperand(calculatorContext));
			calculatorContext.addFirstOperand(calculatorContext.getValue());
			calculatorContext.setDisplayString(calculatorContext.getValue());
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, calculatorContext.getDisplayString().toString()));

		} else {
			/* User clicks non-digit button so the system remains unchanged */
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
		}
	}
}
