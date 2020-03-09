package com.drexel.samyam;

public class Operand extends OperatorComponent {

	public Operand(String value) {
		super(value);
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.visitOperand(this);
	}

}
