package src.simulator;

import java.util.ArrayList;
import src.simulator.vehicles.Flyable;

class Tower {

	public ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (!this.observers.contains(flyable)) {
			this.observers.add(flyable);
		}
	}

	public void unregister(Flyable flyable) {
		if (this.observers.contains(flyable)) {
			this.observers.remove(flyable);
		}
	}

	//This method is added to optimize the work of the program
	public int getObserversSize() {
		return this.observers.size();
	}

	protected void conditionsChanged() {
		/*
		**The variable is needed to compare the size (whether an element was removed)
		**Was not possible to do with an Iterator due to the UML (at least I have found no way)
		*/
		int size = this.observers.size();
		for (int i = 0; i < this.observers.size(); ++i) {
			this.observers.get(i).updateConditions();
			if (size != this.observers.size()) {
				--i;
				size = this.observers.size();
			}
		}
	}
}
