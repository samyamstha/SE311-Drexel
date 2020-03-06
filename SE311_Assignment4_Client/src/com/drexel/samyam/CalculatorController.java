package com.drexel.samyam;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController {

	private CalculatorView calculatorView;
	private CalculatorModel calculatorModel;

	public CalculatorController() {

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
		}

	}

	public void setCalculatorView(CalculatorView view) {
		calculatorView = view;
		
		for(Component button : calculatorView.getButtonPanel().getComponents()) {
			((JButton)button).addActionListener(new ButtonListener());
		}
	}
}
