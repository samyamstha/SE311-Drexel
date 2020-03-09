package com.drexel.samyam;

public class MainDriver {

	public static void main(String[] args) {
	CalculatorView calculatorView = new CalculatorView();	
	CalculatorController calculatorController = new CalculatorController();
	CalculatorContext calculatorContext = new CalculatorContext();
	calculatorContext.setState(new Start(calculatorContext));
	calculatorController.setCalculatorView(calculatorView);
	calculatorController.setCalculatorContext(calculatorContext);
	
	}

}
