package com.drexel.samyam;

import java.awt.event.ActionEvent;

public class GetSecondOperand extends State {

	public GetSecondOperand(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		System.out.println("GetSecondOperand");
		String input = calculatorContext.getValue();
		
		if(operators.contains(input)) {
			// TODO get to the error state
		} else if(digits.contains(input)) {
			calculatorContext.addSecondOperand(calculatorContext.getValue());
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
					calculatorContext.getFirstOperand().toString() + calculatorContext.getOperator() + calculatorContext.getSecondOperand().toString()));
		} else if (input.equalsIgnoreCase("C")) {
			reset();
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
		}
	}
}
