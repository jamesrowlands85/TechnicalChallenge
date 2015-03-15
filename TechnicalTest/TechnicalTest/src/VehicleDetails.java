public interface VehicleDetails {
	
	public void parseJSON(String jsonVehicleDetails);
	
	public String calculateSpecification(String SIPP);
	
	public int calculateScore();

}
