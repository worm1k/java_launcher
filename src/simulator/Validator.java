package src.simulator;

import src.exceptions.ValidationException;

class Validator {
	public static void validateLine(String[] splitLine) throws ValidationException {
		validateNumberOfElementsInLine(splitLine);
		validateType(splitLine[0]);
		validateName(splitLine[1]);
		validateLongitude(splitLine[2]);
		validateLatitude(splitLine[3]);
		validateHeight(splitLine[4]);
	}

	private static void validateNumberOfElementsInLine(String[] splitLine) throws ValidationException {
		if (splitLine.length != 5) {
			throw (new ValidationException("Something is not right. Check the validity of your file."));
		}
	}

	private static void validateType(String type) throws ValidationException {
		if (!"Baloon".equals(type)     &&
			!"Helicopter".equals(type) &&
			!"JetPlane".equals(type))
		{
			throw (new ValidationException("The type is not valid"));
		}
	}

	private static void validateName(String name) throws ValidationException {
		if (name == null || name.isEmpty()) {
			throw (new ValidationException("The name is not valid"));
		}
	}

	private static void validateLongitude(String longitude) throws ValidationException {
		int num = Integer.parseInt(longitude);
		if (num < 0) {
			throw (new ValidationException("Longitude cannot be lower than 0"));
		}
	}

	private static void validateLatitude(String latitude) throws ValidationException {
		int num = Integer.parseInt(latitude);
		if (num < 0) {
			throw (new ValidationException("Latitude cannot be lower than 0"));
		}
	}

	private static void validateHeight(String height) throws ValidationException {
		int num = Integer.parseInt(height);
		if (num <= 0 || num > 100) {
			throw (new ValidationException("Height cannot be lower or equal to 0 or heigher than 100"));
		}
	}
}
