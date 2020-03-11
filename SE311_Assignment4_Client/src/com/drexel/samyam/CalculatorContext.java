package com.drexel.samyam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorContext {

	private String value;
	private State state;
	private ArrayList<ActionListener> actionListenerList;
	private StringBuilder firstOperand;
	private StringBuilder secondOperand;
	private String operator;
	private ArrayList<String> expressions;
	private StringBuilder displayString;
	private State prevState;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getPrevState() {
		return prevState;
	}

	public void setPrevState(State prevState) {
		this.prevState = prevState;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public StringBuilder getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		if (this.displayString == null) {
			this.displayString = new StringBuilder();
		}
		this.displayString.append(displayString);
	}

	public StringBuilder getFirstOperand() {
		return firstOperand;
	}

	public void addFirstOperand(String firstOperand) {
		if (this.firstOperand == null) {
			this.firstOperand = new StringBuilder();
		}
		this.firstOperand.append(firstOperand);
	}

	public StringBuilder getSecondOperand() {
		return secondOperand;
	}

	public void addSecondOperand(String secondOperand) {
		if (this.secondOperand == null) {
			this.secondOperand = new StringBuilder();
		}
		this.secondOperand.append(secondOperand);
	}
	
	public void addSuccessfulExpression(String expression) {
		if (this.expressions == null) {
			this.expressions = new ArrayList<String>();
		}
		this.expressions.add(expression);
	}
	
	public void resetAll() {
		resetOperands();
		resetDisplayString();
		operator = null;
		state = new Start(this);
		
	}
	
	public void resetOperands() {
		firstOperand = null;
		secondOperand = null;
	}
	
	public void resetDisplayString() {
		displayString = null;
	}

	/**
	 * Register an action event listener.
	 */
	public synchronized void addActionListener(ActionListener l) {
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();
		actionListenerList.add(l);
	}

	/**
	 * Remove an action event listener.
	 */
	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l))
			actionListenerList.remove(l);
	}

	/**
	 * Fire event.
	 */
	public void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;

		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}

		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}

}
