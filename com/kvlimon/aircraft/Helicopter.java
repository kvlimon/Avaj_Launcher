package com.kvlimon.aircraft;

import java.util.HashMap;
import com.kvlimon.weather.WeatherProvider;

public class Helicopter extends Aircraft {
    Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

	private static HashMap<String, int[]> weatherDeviation;
	static {
		weatherDeviation = new HashMap<String, int[]>();
		weatherDeviation.put("SUN", new int[] {10, 0, 2});
		weatherDeviation.put("RAIN", new int[] {5, 0, 0});
		weatherDeviation.put("FOG", new int[] {1, 0, 0});
		weatherDeviation.put("SNOW", new int[] {0, 0, -12});
	}

	private static HashMap<String, String> weatherLog;
	static {
		weatherLog = new HashMap<String, String>();
		weatherLog.put("SUN", "Esto es calor.");
		weatherLog.put("RAIN", "lluvia purpura...");
		weatherLog.put("FOG", "Todo es borroso.");
		weatherLog.put("SNOW", "Mi rotor se va a congelarrr!");
	}

    @Override
    public void updateConditions() {
		String weather = WeatherProvider.getCurrentWeather(this.coordinates);
		this.coordinates.setCoordinates(weatherDeviation.get(weather));

		System.out.println(this.getName() + ": " + weatherLog.get(weather));

		if (this.coordinates.getHeight() <= 0) {
			System.out.println(this.getName() + " " + "Landing.");
			this.unregisterFlyableFromTower();
		}
    }

    @Override
    public String getName() {
        return "Helicopter" + "#" + this.name + "(" + String.valueOf(this.id) + ")";
    }
}
