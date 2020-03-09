package com.drexel.samyam;

public abstract class Visitor {
	
	public abstract void visitOperator(OperatorComposite operator);
	public abstract double visitOperand(Operand operand);

}
