package zoo;

public class Lion extends Feline {
	
	// Creates constructor that takes in String name
	public Lion(String name) {
		super(name);
	}
	
	// overrides the makeNoise() method from the Feline class
	
	public void makeNoise() {
		System.out.println(this.getClass() + " " + this.name + " " + " growling");
	}
}

