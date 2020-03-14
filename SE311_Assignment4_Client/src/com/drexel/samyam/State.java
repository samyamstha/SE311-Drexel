package com.drexel.samyam;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

		String result = String.valueOf(visitor.getResult());
		// display the result on the calculator

		if (displayResult) { // send the successful expression to the server
			calculatorContext.processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, result));
			feedServer(calculatorContext.getDisplayString() + EQUALS + result);
		} else {
			resetOperands();
			calculatorContext.addFirstOperand(result);
		}
	}

	private void feedServer(String expression) {
		try {
			Socket socket = new Socket("localhost", 3000);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(expression);
//			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
