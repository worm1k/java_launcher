package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.utility.Writer;

class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if (weather.equals("RAIN")) {
			Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
			this.coordinates = new Coordinates(longitude, latitude, height - 5);
		}
		else if (weather.equals("FOG")) {
			Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): Fog everywhere. Are we in London already?.");
			this.coordinates = new Coordinates(longitude, latitude, height - 3);
		}
		else if (weather.equals("SUN")) {
			Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
			if (height > 96) {
				this.coordinates = new Coordinates(longitude + 2, latitude, 100);
			} else {
				this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
			}
		}
		else if (weather.equals("SNOW")) {
			Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
			this.coordinates = new Coordinates(longitude, latitude, height - 15);
		}
		else {
			System.out.println("Invalid weather condition: " + weather);
		}
		
		if (this.coordinates.getHeight() <= 0) {
			Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			Writer.writeIntoAFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Writer.writeIntoAFile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
