package com.drexel.samyam;

import java.util.ArrayList;


public class OperatorComposite extends OperatorComponent{
	
	ArrayList<OperatorComponent> children = new ArrayList<OperatorComponent>();
	
	
	public OperatorComposite(String value) {
		super(value);
	}

	public ArrayList<OperatorComponent> getChildren() {
		return children;
	}
	
	public void addChild(OperatorComponent operator) {

	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.visitOperator(this);
	}

}
