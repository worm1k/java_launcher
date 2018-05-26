package src.simulator.vehicles;

import src.simulator.vehicles.Coordinates;

class Aircraft {
	
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}

	private long nextId() {
		return ++(this.idCounter);
	}
}
