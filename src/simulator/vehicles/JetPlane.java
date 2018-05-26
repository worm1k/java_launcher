package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.utility.Writer;

class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if (weather.equals("RAIN")) {
			Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
			this.coordinates = new Coordinates(longitude, latitude + 5, height);
		}
		else if (weather.equals("FOG")) {
			Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): What a beautiful foggy weather.");
			this.coordinates = new Coordinates(longitude, latitude + 1, height);
		}
		else if (weather.equals("SUN")) {
			Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): Sun is shining. Give me my sunglasses.");
			if (height > 98) {
				this.coordinates = new Coordinates(longitude, latitude + 10, 100);
			} else {
				this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
			}
		}
		else if (weather.equals("SNOW")) {
			Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
			this.coordinates = new Coordinates(longitude, latitude, height - 7);
		}
		else {
			System.out.println("Invalid weather condition: " + weather);
		}

		if (this.coordinates.getHeight() <= 0) {
			Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			Writer.writeIntoAFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Writer.writeIntoAFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
