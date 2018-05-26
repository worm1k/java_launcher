package src.weather;

import src.simulator.vehicles.Coordinates;

public class WeatherProvider {
	
	private static WeatherProvider weatherProvider = null;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int randNumber = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) / 3;
		return weather[randNumber % 4];
	}
}
