package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.utility.Writer;

class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if (weather.equals("RAIN")) {
			Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): It is raining! I have just cleaned my chopper.");
			this.coordinates = new Coordinates(longitude + 5, latitude, height);
		}
		else if (weather.equals("FOG")) {
			Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): This fog is heavy. I am scared.");
			this.coordinates = new Coordinates(longitude + 1, latitude, height);
		}
		else if (weather.equals("SUN")) {
			Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): This is hot.");
			if (height > 98) {
				this.coordinates = new Coordinates(longitude + 10, latitude, 100);
			} else {
				this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
			}
		}
		else if (weather.equals("SNOW")) {
			Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): My rotor is going to freeze!");
			this.coordinates = new Coordinates(longitude, latitude, height - 12);
		}
		else {
			System.out.println("Invalid weather condition: " + weather);
		}

		if (this.coordinates.getHeight() <= 0) {
			Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			Writer.writeIntoAFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Writer.writeIntoAFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
