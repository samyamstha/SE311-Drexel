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

		if (operators.contains(input)) {
			calculatorContext.setState(new WaitingNextOperand(calculatorContext));
			String temp = calculatorContext.getDisplayString().toString();
			calculatorContext.resetDisplayString();
			calculatorContext.setDisplayString(
					"(" + temp + ")" + calculatorContext.getValue());
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
					calculatorContext.getDisplayString().toString()));
			performCalculation(false);
			calculatorContext.setOperator(input);

		} else if (digits.contains(input)) {
			calculatorContext.addSecondOperand(calculatorContext.getValue());
			calculatorContext.setDisplayString(calculatorContext.getValue());
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
					calculatorContext.getDisplayString().toString()));
		} else if (input.equalsIgnoreCase(RESET)) {
			reset();
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, EMPTY_STRING));
		} else if (input.equals(EQUALS)) {
			// change the state to calculate then call the calculate logic right here
			Calculate calculate = new Calculate(calculatorContext);
			calculatorContext.setState(calculate);
			performCalculation(true);
		}
	}
}
