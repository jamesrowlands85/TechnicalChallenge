
public class Specification {
	private String carType = "";
	private String doorsCarType = "";
	private String transmission= "";
	private String fuel = "";
	private int score = 0;
	
	public Specification(String carType, String doorsCarType, String transmission, String fuel, int score) {
		this.carType = carType;
		this.doorsCarType = doorsCarType;
		this.transmission = transmission;
		this.fuel = fuel;
		this.setScore(score);
	}
	
	public String getDoorsCarType() {
		return doorsCarType;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public void setDoorsCarType(String doorsCarType) {
		this.doorsCarType = doorsCarType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
