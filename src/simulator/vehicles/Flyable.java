package src.simulator.vehicles;

import src.simulator.WeatherTower;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}
