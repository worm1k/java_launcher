package src.simulator;

import src.simulator.Tower;
import src.simulator.vehicles.Coordinates;
import src.weather.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}
