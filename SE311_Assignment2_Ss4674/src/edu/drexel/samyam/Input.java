package edu.drexel.samyam;

public abstract class Input extends Filter{
	
	public Input(Pipe input, Pipe output) {
		super(input, output);
	}

	protected Validate validate;	

}
