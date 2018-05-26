package src.simulator.vehicles;

import src.simulator.vehicles.Baloon;
import src.simulator.vehicles.JetPlane;
import src.simulator.vehicles.Helicopter;
import src.exceptions.AircraftException;

public class AircraftFactory {
	
	/*
	**Currently there are only 3 types of supported aircrafts
	**All aircraft types are case insensitive
	*/
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AircraftException {

		if ("baloon".equals(type.toLowerCase())) {
			return new Baloon(name, new Coordinates(longitude, latitude, height));
		} else if ("jetplane".equals(type.toLowerCase())) {
			return new JetPlane(name, new Coordinates(longitude, latitude, height));
		} else if ("helicopter".equals(type.toLowerCase())) {
			return new Helicopter(name, new Coordinates(longitude, latitude, height));
		} else {
			throw (new AircraftException("This type of aircraft is not supported in this version of the program"));
		}
	}
}
