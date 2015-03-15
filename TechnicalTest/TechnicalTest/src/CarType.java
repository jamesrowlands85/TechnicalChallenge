
public enum CarType {
	Mini ("Mini"),
	Economy ("Economy"),
	Compact ("Compact"),
	Intermediate ("Intermediate"),
	Standard ("Standard"),
	FullSize ("Full Size"),
	Premium ("Premium"),
	Luxury ("Luxury"),
	Special ("Special");
	
	private final String name;       

    private CarType(String name) {
        this.name = name;
    }

    public String toString(){
       return name;
    }
}
