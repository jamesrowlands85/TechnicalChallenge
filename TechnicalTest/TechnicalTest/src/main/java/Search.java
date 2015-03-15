import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;


public class Search {
	private List<Vehicle> vehicleList;

	@JsonGetter("VehicleList")
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
}
