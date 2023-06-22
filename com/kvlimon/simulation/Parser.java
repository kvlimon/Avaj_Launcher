package com.kvlimon.simulation;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

import com.kvlimon.exception.AvajCoordinateException;
import com.kvlimon.exception.AvajIllegalArgumentException;

public class Parser {
	public static ConfigRecord parseConfigFile(String conf) {
		Scanner myReader = null;
		int weatherCycles = 0;
		ArrayList<String[]> flyables = new ArrayList<String[]>();
		
		try {
			File configFile = new File(conf);
			myReader = new Scanner(configFile);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				if (weatherCycles == 0) {
					if ((weatherCycles = Integer.valueOf(data)) <= 0) {
						throw new AvajIllegalArgumentException("Wrong number of weather cycles, it should be positive");
					}
					continue ;
				}

				String[] flyableData = data.split(" ");

				if (flyableData.length != 5) {
					throw new AvajIllegalArgumentException("Wrong number of flyable details");
				}

				String tmp = flyableData[0].toLowerCase();

				if (tmp.compareTo("jetplane") != 0 && tmp.compareTo("baloon") != 0 && tmp.compareTo("helicopter") != 0) {
					throw new AvajIllegalArgumentException("Wrong flyable object, only Baloon, JetPlane and Helicopter are accepted.");
				}

				String regex = "^[A-Z][0-9]";

				if (flyableData[1].length() != 2 || flyableData[1].matches(regex) == false) {
					throw new AvajIllegalArgumentException("Wrong flyable type nomenclature, i.e. B1");
				}

				int longitude = Integer.valueOf(flyableData[2]);
				int latitude = Integer.valueOf(flyableData[3]);
                int height = Integer.valueOf(flyableData[4]);

				if (height < 0) {
					throw new AvajIllegalArgumentException("Illegal coordinates, height is out of range");
				} else if (height > 100) {
					height = 100;
				} else if (longitude > 1000 || longitude < 0) {
                    throw new AvajCoordinateException("Longitude is out of range, 0-1000.");
                } else if (latitude > 1000 || longitude < 0) {
                    throw new AvajCoordinateException("Latitude is out of range, 0-1000.");
                }

                flyables.add(flyableData);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception.");
			e.printStackTrace();
		} catch(AvajIllegalArgumentException e) {
			System.out.println("Illegal Argument Exception.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
			if (myReader != null) {
				myReader.close();
			}
		}
		return new ConfigRecord(flyables, weatherCycles);
	}
}