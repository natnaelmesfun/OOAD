package zoo;
public class Animals {
	public String name;
	
	public Animals(String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("My type is " + this.getClass() + " " + this.name + " Making Noise");
	}
	
	public void sleep() {
		System.out.println("My type is " + this.getClass() + " " +  this.name + " Going to sleep");
	}
	
	public void eat() {
		System.out.println("My type is " + this.getClass() + " " + this.name + " Eating my meal");
	}
	
	public void roam() {
		System.out.println("My type is " + this.getClass() + " " + this.name + " Moving around");
	}
	
	public void wakingUp() {
		System.out.println("My type is " + this.getClass() + " " + this.name + "," + "good morning");
	}
}








