package edu.drexel.samyam;

public class MyEvent {

	private int lineIndex;
	private int eventType;
	private String line; 
	 

	public final static int LINE_ADDED = 100;
	public final static int PRINT_READY = 200;
	public final static int LINE_REMOVED = 300;
	public final static int ALBHABETIZE = 400;

	public MyEvent(int index, int eventType) {
		this.lineIndex = index;
		this.eventType = eventType;
	}
	
	public MyEvent(String line, int eventType) {
		this.eventType = eventType;
		this.line = line;
	}

	public int getLineIndex() {
		return this.lineIndex;
	}

	public int getEventType() {
		return eventType;
	}
	
	public String getLine() {
		return line;
	}

}
