package com.kvlimon.aircraft;

import com.kvlimon.weather.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;
    public abstract void updateConditions();
    public abstract String getName(); 

    public void registerTower(WeatherTower tower) {
        weatherTower = tower;
    }

    public void registerFlyableIntoTower() {
        weatherTower.register(this);
    }

	public void unregisterFlyableFromTower() {
		weatherTower.unregister(this);
	}
}
