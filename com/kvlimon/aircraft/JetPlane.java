package com.kvlimon.aircraft;

import java.util.HashMap;
import com.kvlimon.weather.WeatherProvider;

public class JetPlane extends Aircraft {
    JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

	private static HashMap<String, int[]> weatherDeviation;
	static {
		weatherDeviation = new HashMap<String, int[]>();
		weatherDeviation.put("SUN", new int[] {0, 10, 2});
		weatherDeviation.put("RAIN", new int[] {0, 5, 0});
		weatherDeviation.put("FOG", new int[] {0, 1, 0});
		weatherDeviation.put("SNOW", new int[] {0, 0, -7});
	}

	private static HashMap<String, String> weatherLog;
	static {
		weatherLog = new HashMap<String, String>();
		weatherLog.put("SUN", "This is hot.");
		weatherLog.put("RAIN", "Purple rain...");
		weatherLog.put("FOG", "Everything is blurry.");
		weatherLog.put("SNOW", "My rotor is going to freeze!");
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
		return "JetPlane" + "#" + this.name + "(" + String.valueOf(this.id) + ")";
    }
}
