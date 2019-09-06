package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers;

	public Subject() {
		super();
		this.observers = new ArrayList<Observer>();
	}
	
	public void attach(Observer o) {
		this.observers.add(o);
	}
	
	public void dettach(Observer o) {
		this.observers.remove(o);
	}
	
	protected void report() {
		for (Observer o : this.observers) {
			o.update(this);
		}
	}
	
}
