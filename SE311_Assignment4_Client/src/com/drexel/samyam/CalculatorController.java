package com.drexel.samyam;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;

public class CalculatorController {

	private CalculatorView calculatorView;
	private CalculatorContext calculatorContext;

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

	public State getState() {
		return calculatorContext.getState();
	}

	public void feedServer(String expression) {
		try {
			Socket socket = new Socket("localhost", 3000);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(expression);
//			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Action Listener to the Calculator Buttons */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String inputValue = e.getActionCommand();
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
