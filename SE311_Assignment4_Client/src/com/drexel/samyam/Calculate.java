package com.drexel.samyam;

public class Calculate extends State {

	public Calculate(CalculatorContext calculatorContext) {
		super(calculatorContext);
	}

	@Override
	public void performAction() {
		System.out.println("Calculate State");
	}

}
