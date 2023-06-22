package com.kvlimon.weather;

import java.util.ArrayList;
import com.kvlimon.aircraft.Flyable;

public class Tower {
    private ArrayList<Flyable> observers;

	Tower() {
		observers = new ArrayList<Flyable>();
	}

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getName() + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable.getName() + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
		for (int i = 0; i < observers.size(); i++) {
			Flyable flyable = observers.get(i);
			flyable.updateConditions();
		}
    }
}