package zoo;

public class Lion extends Feline {
	public Lion(String name) {
		super(name);
	}
	
	public void makeNoise() {
		System.out.println(this.getClass() + " " + this.name + " " + " growling");
	}
}

