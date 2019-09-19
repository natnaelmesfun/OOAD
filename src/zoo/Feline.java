package zoo;
public class Feline extends Animals {
	public Feline(String name) {
		super(name);
	}
	public void hasTails() {
		System.out.println(this.name + "have tail");
	}	
	
	public void makeNoise() {
		System.out.println("Feline making Noise");
	}
}
