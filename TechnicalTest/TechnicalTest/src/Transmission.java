
public enum Transmission {
	Manual ("Manual"),
	Automatic ("Automatic");
	
	private final String name;       

    private Transmission(String name) {
        this.name = name;
    }

    public String toString(){
       return name;
    }
}
