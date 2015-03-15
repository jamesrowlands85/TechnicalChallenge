import java.util.HashMap;
import java.util.Map;


public class SpecificationRepository {

	Map<String, String> carTypes = new HashMap<>();
	
	Map<String, String> doorsCarTypes = new HashMap<>();
	
	Map<String, String> transmissions = new HashMap<>();
	
	Map<String, String> fuelAirCons = new HashMap<>();
	
	public SpecificationRepository() {
		createCarTypeMap();
		createDoorsCarTypeMap();
		createTransmissionMap();		
		createFuelAirConMap();		
	}

	private void createFuelAirConMap() {
		fuelAirCons.put("N", "Petrol/no AC");
		fuelAirCons.put("R", "Petrol/AC");
	}

	private void createTransmissionMap() {
		transmissions.put("M", "Manual");
		transmissions.put("A", "Automatic");
	}

	private void createDoorsCarTypeMap() {
		doorsCarTypes.put("B", "2 Doors");
		doorsCarTypes.put("C", "4 Doors");
		doorsCarTypes.put("D", "5 Doors");
		doorsCarTypes.put("W", "Estate");
		doorsCarTypes.put("T", "Convertible");
		doorsCarTypes.put("F", "SUV");
		doorsCarTypes.put("P", "Pick up");
		doorsCarTypes.put("V", "Passenger Van");
	}

	private void createCarTypeMap() {
		carTypes.put("M", "Mini");
		carTypes.put("E", "Economy");
		carTypes.put("C", "Compact");
		carTypes.put("I", "Intermediate");
		carTypes.put("S", "Standard");
		carTypes.put("F", "Full Size");
		carTypes.put("P", "Premium");
		carTypes.put("L", "Luxury");
		carTypes.put("X", "Special");
	}
	
	public Specification getSpecification(String sipp) {
		String carType = carTypes.get(String.valueOf(sipp.charAt(0)));
		String doorsCarType = doorsCarTypes.get(String.valueOf(sipp.charAt(1)));
		String transmission = transmissions.get(String.valueOf(sipp.charAt(2)));
		String fuelAirCon = fuelAirCons.get(String.valueOf(sipp.charAt(3)));
		
		int score = 0;
		if(String.valueOf(sipp.charAt(2)) == "M") {
			score += 1;
		}
		else {
			score += 5;
		}
		if(String.valueOf(sipp.charAt(3)) == "R") {
			score += 2;
		}
		
		return new Specification(carType, doorsCarType, transmission , fuelAirCon, score);		
	}
	

	
}
