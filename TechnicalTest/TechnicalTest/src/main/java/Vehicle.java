import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Vehicle {

	private String name;
	private BigDecimal price = null;
	private String sipp;
	private double rating = 0;
	private String supplier = "";
	
	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getSIPP() {
		return sipp;
	}

	public double getRating() {
		return rating;
	}

	public String getSupplier() {
		return supplier;
	}
	
		

	
	@JsonCreator
	public Vehicle(		@JsonProperty("name") String name,
						@JsonProperty("sipp") String sipp,
						@JsonProperty("price") BigDecimal price,
						@JsonProperty("supplier") String supplier,
						@JsonProperty("rating") double rating) {
		this.name = name;
		this.sipp = sipp;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}	
}
