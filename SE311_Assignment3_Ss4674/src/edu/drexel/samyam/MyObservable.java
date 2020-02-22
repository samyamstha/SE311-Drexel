package edu.drexel.samyam;

import java.util.ArrayList;

public abstract class MyObservable {

	ArrayList<MyObserver> observers;

	public MyObservable() {
		observers = new ArrayList<MyObserver>();
	}

	public void attach(MyObserver observer) {
		if (observer == null)
			throw new NullPointerException();
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void detach(MyObserver observer) {
		observers.remove(observer);
	}

	public void notifyAllObservers(MyEvent event) {
		for (MyObserver observer : observers) {
			observer.update(event);
		}
	}

}
