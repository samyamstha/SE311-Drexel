package com.drexel.samyam;

public abstract class OperatorComponent {
	
	private String value;
	
	public OperatorComponent(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public abstract void acceptVisitor(Visitor visitor);	

}
