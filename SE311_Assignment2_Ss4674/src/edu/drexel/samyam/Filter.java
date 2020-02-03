package edu.drexel.samyam;

public abstract class Filter implements Runnable {

	
	protected Pipe input;
	protected Pipe output;
	private boolean is_started;
	
	
	public Filter(Pipe input, Pipe output) {
		this.input = input;
		this.output = output;
		is_started = false;
	}


	
	@Override
	public void run() {
		transform();

	}
	
	public void start(){
	    if(!is_started){
	        is_started = true;
	        Thread thread = new Thread(this);
	        thread.start();
	      }
	}
	
	public void stop(){
		is_started = false;
		
	}
	
	protected abstract void transform();
}
