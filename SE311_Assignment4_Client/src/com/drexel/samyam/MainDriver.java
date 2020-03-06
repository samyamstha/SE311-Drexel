package com.drexel.samyam;

public class MainDriver {

	public static void main(String[] args) {
	CalculatorView calculatorView = new CalculatorView();	
	CalculatorController calculatorController = new CalculatorController();
	
	calculatorController.setCalculatorView(calculatorView);
	}

}
