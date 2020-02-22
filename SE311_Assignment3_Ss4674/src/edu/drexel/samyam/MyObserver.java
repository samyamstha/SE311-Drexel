package edu.drexel.samyam;

public abstract class MyObserver {
	
	private MyObservable subject;
	
	public abstract void update(MyEvent event);
	
	public boolean isMyEvent(int firedEventType, int myEventType) {
		if (firedEventType == myEventType) {
			return true;
		}
		return false;
	}

}
