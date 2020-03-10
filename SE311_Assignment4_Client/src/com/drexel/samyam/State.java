package com.drexel.samyam;

import java.awt.event.ActionEvent;

public abstract class State {

	protected CalculatorContext calculatorContext;
	protected String operators = "+-*/";
	protected String digits = "1234567890";
	protected String EMPTY_STRING = "";
	protected String EQUALS = "=";
	protected String RESET = "C";

	public State(CalculatorContext calculatorContext) {
		this.calculatorContext = calculatorContext;
	}

	public abstract void performAction();

	public void reset() {
		calculatorContext.resetAll();
	}
	
	public void resetOperands() {
		calculatorContext.resetOperands();
	}

	public void performCalculation(Boolean displayResult) {
		OperationVisitor visitor = new OperationVisitor();
		OperatorComposite root = new OperatorComposite(calculatorContext.getOperator());
		root.addChild(new Operand(calculatorContext.getFirstOperand().toString()));
		root.addChild(new Operand(calculatorContext.getSecondOperand().toString()));
		root.acceptVisitor(visitor);

		// display the result on the calculator
		if (displayResult) {
			calculatorContext.processEvent(
					new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(visitor.getResult())));
		} else {
			resetOperands();
			calculatorContext.addFirstOperand(String.valueOf(visitor.getResult()));
		}
	}
}
