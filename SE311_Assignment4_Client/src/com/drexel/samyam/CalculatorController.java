package com.drexel.samyam;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class CalculatorController {

	private CalculatorView calculatorView;
	private CalculatorContext calculatorContext;
	private OperatorComponent operator;

	public CalculatorController() {

	}

	/* setters and getters */
	public CalculatorView getCalculatorView() {
		return calculatorView;
	}

	public void setCalculatorView(CalculatorView view) {
		calculatorView = view;

		/* attach listeners to the view buttons */
		for (Component button : calculatorView.getButtonPanel().getComponents()) {
			((JButton) button).addActionListener(new ButtonListener());
		}
	}

	public CalculatorContext getCalculatorContext() {
		return calculatorContext;
	}

	public void setCalculatorContext(CalculatorContext calculatorContext) {
		this.calculatorContext = calculatorContext;
		calculatorContext.addActionListener(new LabelListener());
	}

	public OperatorComponent getOperator() {
		return operator;
	}

	public void setOperator(OperatorComponent operator) {
		this.operator = operator;
	}

	public State getState() {
		return calculatorContext.getState();
	}

	/* Action Listener to the Calculator Buttons */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String inputValue = e.getActionCommand();
			System.out.println(e.getActionCommand());
			calculatorContext.setValue(inputValue);
			getState().performAction();

		}

	}
	
	/* Action Listener to the Calculator Display Label */
	private class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			calculatorView.getoutputLabel().setText(e.getActionCommand());

		}

	}

}
