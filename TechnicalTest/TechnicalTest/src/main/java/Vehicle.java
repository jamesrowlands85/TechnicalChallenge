import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Vehicle {

	private String name;
	private BigDecimal price = null;
	private String SIPP;
	private double rating = 0;
	private String supplier = "";
	
	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getSIPP() {
		return SIPP;
	}

	public double getRating() {
		return rating;
	}

	public String getSupplier() {
		return supplier;
	}
	
		

	
	@JsonCreator
	public Vehicle(		@JsonProperty("name") String name,
						@JsonProperty("sipp") String SIPP,
						@JsonProperty("price") BigDecimal price,
						@JsonProperty("supplier") String supplier,
						@JsonProperty("rating") double rating) {
		this.name = name;
		this.SIPP = SIPP;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}	
}
