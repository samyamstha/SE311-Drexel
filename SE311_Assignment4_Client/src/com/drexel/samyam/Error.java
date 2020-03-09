package com.drexel.samyam;

public class Error extends State{

	public Error(CalculatorContext calculatorContext) {
		super(calculatorContext);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performAction() {
		System.out.println("Error St!ate");
	}
}
