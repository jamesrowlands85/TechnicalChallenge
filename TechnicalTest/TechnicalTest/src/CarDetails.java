import java.math.BigDecimal;


public class CarDetails implements VehicleDetails {
	
	public String name = null;
	public BigDecimal price = null;
	public String SIPP;
	public CarType type = null;
	public CarTypeDoors carTypeDoors = null;
	public Transmission transmission = null;
	public String fuelType = null;
	public boolean airCon = false;
	public String supplier = "";
	public int rating = 0;
	public int supplierRating = 0;
	
	public CarDetails(String jsonVehicleDetails) {
		parseJSON(jsonVehicleDetails);
	}

	@Override
	public String calculateSpecification(String SIPP) {
		return "";
		
	}

	@Override
	public int calculateScore() {
		int vehicleScore = 0;
		if(transmission == Transmission.Automatic) {
			vehicleScore += 5;
		}
		if(transmission == Transmission.Manual) {
			vehicleScore += 1;
		}
		if(airCon) {
			vehicleScore += 2;
		}

		return vehicleScore;
	}

	@Override
	public void parseJSON(String jsonCarDetails) {
		// TODO Auto-generated method stub
		
	}
	
	public String specification() {
		String airConDescription = "";
		if(airCon) {
			airConDescription = "AirCon";
		}
		else {
			airConDescription = "No Air Con";
		}
		
		return name + "-" + SIPP + "-" + type + "-" + carTypeDoors + "-" + transmission + "-" + fuelType + "-" + airConDescription;
	}

}
