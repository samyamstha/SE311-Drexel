package com.drexel.samyam;

import java.util.ArrayList;

public class OperationVisitor extends Visitor {

	private ArrayList<Double> operands = new ArrayList<Double>();
	private double result;
	private String PLUS = "+";
	private String SUBTRACT = "-";
	private String MULTIPLY = "*";
	private String DIVIDE = "/";

	@Override
	public void visitOperator(OperatorComposite operator) {
		String operation = operator.getValue();

		for (OperatorComponent child : operator.getChildren()) {
			child.acceptVisitor(this);
		}

		if (operation.equals(PLUS)) {
			result = operands.get(0) + operands.get(1);
		} else if (operation.equals(SUBTRACT)) {
			result = operands.get(0) - operands.get(1);
		} else if (operation.equals(MULTIPLY)) {
			result = operands.get(0) * operands.get(1);
		} else if (operation.equals(DIVIDE)) {
			result = operands.get(0) / operands.get(1);
		}

	}

	@Override
	public void visitOperand(Operand operand) {
		operands.add(Double.parseDouble(operand.getValue()));
	}
	
	public double getResult() {
		return result;
	}

}
