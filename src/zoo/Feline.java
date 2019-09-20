package zoo;
public class Feline extends Animals {
	
	// Creates constructor that takes in String name
	
	public Feline(String name) {
		super(name);
	}
	public void hasTails() {
		System.out.println(this.name + "have tail");
	}
	
	// Feline overrides makeNoise() method from the animal class
	
	public void makeNoise() {
		System.out.println("Feline making Noise");
	}
	
	
}
