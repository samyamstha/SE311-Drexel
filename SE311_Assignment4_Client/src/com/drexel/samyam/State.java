package com.drexel.samyam;

public abstract class State {
	
	protected CalculatorContext calculatorContext;
	protected String operators = "+-*/";
	protected String digits = "1234567890";
	protected String EMPTY_STRING = "";
	
	public State(CalculatorContext calculatorContext) {
		this.calculatorContext = calculatorContext;
	}

	public abstract void performAction();
	
	public void reset() {
		calculatorContext.reset();
	}
}
