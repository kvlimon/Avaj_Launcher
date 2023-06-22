package com.kvlimon.simulation;

import java.io.PrintStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;

import com.kvlimon.aircraft.Flyable;
import com.kvlimon.weather.WeatherTower;
import com.kvlimon.aircraft.Coordinates;
import com.kvlimon.aircraft.AircraftFactory;
import com.kvlimon.exception.AvajIllegalArgumentException;

public class Simulation {
	private int weatherCycles;
    private WeatherTower weatherTower = new WeatherTower();
    private ConfigRecord fileRecord;

    private PrintStream printStream = null;
    private FileOutputStream fileOutputStream = null;

	public Simulation(String configFile) {
		fileRecord = Parser.parseConfigFile(configFile);
        this.weatherCycles = fileRecord.weatherCycles();
	}

    public void initRedirection() throws FileNotFoundException {

        System.out.println("Simulation initialized");

        fileOutputStream = new FileOutputStream("simulation.txt");
        printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        
    }

    public void initFlyables() throws AvajIllegalArgumentException {
        for (String[] flyable : fileRecord.flyables()) {
            Coordinates coordinates = new Coordinates(Integer.valueOf(flyable[2]), Integer.valueOf(flyable[3]), Integer.valueOf(flyable[4]));
            Flyable newFlyable = AircraftFactory.newAircraft(flyable[0], flyable[1], coordinates);
            newFlyable.registerTower(weatherTower);
            newFlyable.registerFlyableIntoTower();
        }
    }

    public void activateSimulation() {
        try {

            initRedirection();
            initFlyables();

            for (int i = 0; i < this.weatherCycles; ++i) {
                weatherTower.changeWeather();
            }

            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            System.out.println("End of Simulation");
        
        } catch (AvajIllegalArgumentException e) {
			System.out.println("Illegal Argument Exception.");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("Security Exception.");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception.");
			e.printStackTrace();
        } finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (printStream != null) {
				printStream.close();
			}
		}
    }
}