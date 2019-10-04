package zoo;
public class Cat extends Feline {
	
	public Cat(String name) {
		super(name);
	}
	
	
	/* creates random number from [0,1] , and if that number is below or equal to 0.5, 
	 * invoke makeNoise1() otherwise, invoke makeNoise2()
	 */
	
	public void makeNoise() {
		double x = Math.random();
		
//		System.out.println(x);
		
		if(x <= 0.5) {
			makeNoise1();
		} else {
			makeNoise2();
		}
	}
	
	public void makeNoise1() {
		System.out.println("My type is " + this.getClass() +  " " + this.name + " Me-yao");
	}
	
	public void makeNoise2() {
		System.out.println("My type is " + this.getClass() + " " + this.name + " Hello");
	}
	
	// Reference: https://dzone.com/articles/random-number-generation-in-java
	// for random number generator1
	
}
