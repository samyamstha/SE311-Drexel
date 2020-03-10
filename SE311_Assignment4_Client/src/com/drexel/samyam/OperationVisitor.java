package com.drexel.samyam;

import java.util.ArrayList;

public class OperationVisitor extends Visitor {

	private ArrayList<Double> operands = new ArrayList<Double>();
	private double result;

	@Override
	public void visitOperator(OperatorComposite operator) {
		String operation = operator.getValue();

		for (OperatorComponent child : operator.getChildren()) {
			child.acceptVisitor(this);
		}

		if (operation.equals("+")) {
			result = operands.get(0) + operands.get(1);
		} else if (operation.equals("-")) {
			result = operands.get(0) - operands.get(1);
		} else if (operation.equals("*")) {
			result = operands.get(0) * operands.get(1);
		} else if (operation.equals("/")) {
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
