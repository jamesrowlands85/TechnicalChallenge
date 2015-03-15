
public enum CarTypeDoors {
	TwoDoors ("2 Doors"),
	FourDoors ("4 Doors"),
	FiveDoors ("5 Doors"),
	Estate ("Estate"),
	Convertible ("Convertible"),
	SUV ("SUV"),
	Pickup ("Pick up"),
	PassengerVan ("Passenger Van");
	
	private final String name;       

    private CarTypeDoors(String name) {
        this.name = name;
    }

    public String toString(){
       return name;
    }
}
