package com.kvlimon.aircraft;

import java.util.HashMap;
import com.kvlimon.weather.WeatherProvider;

public class Baloon extends Aircraft {
    Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

	private static HashMap<String, int[]> weatherDeviation;
	static {
		weatherDeviation = new HashMap<String, int[]>();
		weatherDeviation.put("SUN", new int[] {2, 0, 4});
		weatherDeviation.put("RAIN", new int[] {0, 0, -5});
		weatherDeviation.put("FOG", new int[] {0, 0, -3});
		weatherDeviation.put("SNOW", new int[] {0, 0, -15});
	}

	private static HashMap<String, String> weatherLog;
	static {
		weatherLog = new HashMap<String, String>();
		weatherLog.put("SUN", "Il fait chaud dans les clusters.");
		weatherLog.put("RAIN", "Pluie mauve...");
		weatherLog.put("FOG", "Tout est flouté");
		weatherLog.put("SNOW", "Mon rotor va geler!");
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
		return "Baloon" + "#" + this.name + "(" + String.valueOf(this.id) + ")";
    }
}
