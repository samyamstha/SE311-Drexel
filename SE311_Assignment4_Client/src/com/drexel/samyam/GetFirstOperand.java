package com.drexel.samyam;

import java.awt.event.ActionEvent;

public class GetFirstOperand extends State {

	public GetFirstOperand(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		String input = calculatorContext.getValue();
		System.out.println("Get First Operand State");

		if (operators.contains(input)) {
			calculatorContext.setOperator(input);
			calculatorContext.setState(new GetSecondOperand(calculatorContext));
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
					calculatorContext.getFirstOperand().toString() + calculatorContext.getOperator()));

		} else if (digits.contains(input)) {
			calculatorContext.addFirstOperand(calculatorContext.getValue());
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
					calculatorContext.getFirstOperand().toString()));

		} else if (input.equals("=")) {
			// TODO get to error state

		} else if (input.equalsIgnoreCase("C")) {
			reset();
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
		}

	}
}
