package com.drexel.samyam;

public class WaitingNextOperand extends State {

	public WaitingNextOperand(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		System.out.println("WaitingNextOperand");
	}
}
