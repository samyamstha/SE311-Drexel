package com.drexel.samyam;

public class OperationVisitor extends Visitor{

	@Override
	public void visitOperator(OperatorComposite operator) {
		for(OperatorComponent child : operator.getChildren()) {
			child.acceptVisitor(this);
		}
	}

	@Override
	public double visitOperand(Operand operand) {
		return Double.parseDouble(operand.getValue());
	}

}
