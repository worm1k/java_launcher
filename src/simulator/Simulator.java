package src.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import src.simulator.WeatherTower;
import src.simulator.vehicles.Flyable;
import src.simulator.vehicles.AircraftFactory;
import src.exceptions.ValidationException;
import src.exceptions.AircraftException;
import src.utility.Writer;

public class Simulator {

	private static WeatherTower weatherTower = new WeatherTower();
	private static BufferedReader reader = null;

	public static void main(String[] args) {
		try {
			int numberOfSimulations = 0;
			reader = new BufferedReader(new FileReader(args[0]));
			
			String line = reader.readLine();

			if (line != null) {
				numberOfSimulations = Integer.parseInt(line);
				if (numberOfSimulations <= 0) {
					throw (new ValidationException("Invalid number of simulations"));
				}
			} else {
				throw (new ValidationException("The file is empty"));
			}

			Writer.getWriter();
			while ((line = reader.readLine()) != null) {
				String[] splitLine = line.split(" ");
				Validator.validateLine(splitLine);
				Flyable flyable = AircraftFactory.newAircraft(splitLine[0],
															  splitLine[1],
															  Integer.parseInt(splitLine[2]),
															  Integer.parseInt(splitLine[3]),
															  Integer.parseInt(splitLine[4]));
				flyable.registerTower(weatherTower);
			}
			for (int i = 0; i < numberOfSimulations && weatherTower.getObserversSize() != 0; ++i) {
				weatherTower.changeWeather();
			}

		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the file " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Are you tring to get a segmentation fault?");
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + args[0]);
		} catch (NumberFormatException e) {
			System.out.println("An error with the number formatting: " + e.getMessage());
		} catch (AircraftException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Undefined exception");
		} finally {
			try {
				reader.close();
				Writer.closeWriter();
			}
			catch (IOException e) {
				System.out.println("An error with close: " + e.getMessage());
			}
		}
	}
}
