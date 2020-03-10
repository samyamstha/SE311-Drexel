package com.drexel.samyam;

import java.util.ArrayList;


public class OperatorComposite extends OperatorComponent{
	
	ArrayList<OperatorComponent> children;
	
	
	public OperatorComposite(String value) {
		super(value);
	}

	public ArrayList<OperatorComponent> getChildren() {
		return children;
	}
	
	public void addChild(OperatorComponent component) {
		if (children == null) {
			children = new ArrayList<OperatorComponent>();
		}
		children.add(component);
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.visitOperator(this);
	}

}
