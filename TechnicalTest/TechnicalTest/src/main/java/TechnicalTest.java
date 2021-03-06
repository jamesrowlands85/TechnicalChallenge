import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TechnicalTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();		
		TechnicalTest.class.getResourceAsStream("/vehicles.json");
		
		Document carDetails = parseTechnicalTestJson(mapper);
		
		SpecificationRepository carSpecification = new SpecificationRepository();	
		
		System.out.println("Cars with price");
		System.out.println("");
		
		printCarNameAndPrice(carDetails);
		
		System.out.println("");
		System.out.println("Cars with specification");
		System.out.println("");
		
		carDetails = parseTechnicalTestJson(mapper);
		
		printCarSpecification(carDetails, carSpecification);
		
		
		System.out.println("");
		System.out.println("Cars Ordered by Rating");
		System.out.println("");
		
		carDetails = parseTechnicalTestJson(mapper);
		
		printCarDetailsByRatingDescending(carDetails, carSpecification);
		
		System.out.println("");
		System.out.println("Cars Ordered by combined Scores");
		System.out.println("");
		
		carDetails = parseTechnicalTestJson(mapper);
		
		printCombinedScoreDescending(carDetails, carSpecification);
		
	}

	private static Document parseTechnicalTestJson(ObjectMapper mapper)
			throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(TechnicalTest.class.getResourceAsStream("/vehicles.json"), Document.class);
	}

	private static void printCarNameAndPrice(Document carDetails) {
		Collections.sort(carDetails.getSearch().getVehicleList(), new Comparator<Vehicle>() {
			@Override
			public int compare(Vehicle o1, Vehicle o2) {
				return o1.getPrice().compareTo(o2.getPrice());
			}
		});
		
		// print out car name and price
		for(Vehicle car : carDetails.getSearch().getVehicleList()) {
			System.out.println(car.getName() + "-" + car.getPrice());
		}
	}

	private static void printCarSpecification(Document carDetails,
			SpecificationRepository carSpecification) {
		// print out specification
		for(Vehicle car : carDetails.getSearch().getVehicleList()) {
			Specification currentCarSpec = carSpecification.getSpecification(car.getSIPP());
			System.out.println(car.getName() + "-" + car.getSIPP() 
								+ "-" + currentCarSpec.getCarType() + "-" 
								+ currentCarSpec.getDoorsCarType() + "-" 
								+ currentCarSpec.getTransmission() + "-" 
								+ currentCarSpec.getFuel());
		}
	}

	private static void printCarDetailsByRatingDescending(Document carDetails,
			SpecificationRepository carSpecification) {
		// print by rating
		Map<String, List<Vehicle>> carsByType = new HashMap<>();
		
		// place each type into its own list
		for(Vehicle car : carDetails.getSearch().getVehicleList()) {
			Specification currentCarSpec = carSpecification.getSpecification(car.getSIPP());
			List<Vehicle> currentCarType = carsByType.get(currentCarSpec.getCarType());
			if(currentCarType == null) {
				currentCarType = new ArrayList<>();
				carsByType.put(currentCarSpec.getCarType(), currentCarType);
			}
			currentCarType.add(car);
		}
		
		// order by rating and only print the highest rated for each type
		for(Entry<String, List<Vehicle>> entry : carsByType.entrySet()) {
			Collections.sort(entry.getValue(), new Comparator<Vehicle>() {
				@Override
				public int compare(Vehicle o1, Vehicle o2) {
					return (int) ((int) o2.getRating() - o1.getRating());
				}
			});
			Vehicle highestRatedCar = entry.getValue().get(0);
			Specification currentCarSpec = carSpecification.getSpecification(highestRatedCar.getSIPP());
			System.out.println(highestRatedCar.getName() + "-" + currentCarSpec.getCarType() + "-" + highestRatedCar.getSupplier() + "-" + highestRatedCar.getRating());
		}
	}

	private static void printCombinedScoreDescending(	Document carDetails,
														SpecificationRepository carSpecification) {
		// order by spec + rating
		Collections.sort(carDetails.getSearch().getVehicleList(), new Comparator<Vehicle>() {
			@Override
			public int compare(Vehicle o1, Vehicle o2) {
				Specification o1Spec = carSpecification.getSpecification(o1.getSIPP());
				Specification o2Spec = carSpecification.getSpecification(o2.getSIPP());
				return (int) ((o2.getRating() + o2Spec.getScore()) - (o1.getRating() + o1Spec.getScore()));
			}
		});
		
		// print out combined score desc
		for(Vehicle car : carDetails.getSearch().getVehicleList()) {
			Specification currentCarSpec = carSpecification.getSpecification(car.getSIPP());
			System.out.println(car.getName() + "-" 
								+ currentCarSpec.getScore() + "-" 
								+ car.getRating() + "-" 
								+ (car.getRating() + currentCarSpec.getScore()));
		}
	}
}
