package com.kvlimon.aircraft;

import com.kvlimon.exception.AvajIllegalArgumentException;

public class AircraftFactory {
	private static int next_id = 0;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AvajIllegalArgumentException {

        if (p_type.toLowerCase().equals("helicopter")) {
			return new Helicopter(next_id++, p_name, p_coordinates);
        } else if (p_type.toLowerCase().equals("baloon")) {
			return new Baloon(next_id++, p_name, p_coordinates);
        } else if (p_type.toLowerCase().equals("jetplane")) {
			return new JetPlane(next_id++, p_name, p_coordinates);
        } else {
			throw new AvajIllegalArgumentException("Invalid Flyable");
        }
    }
}
