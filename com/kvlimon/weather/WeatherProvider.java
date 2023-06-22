package com.kvlimon.weather;

import com.kvlimon.aircraft.Coordinates;

public final class WeatherProvider {
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static String getCurrentWeather(Coordinates p_coordinates) {
		int index = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4;
		return weather[index];
    }
}