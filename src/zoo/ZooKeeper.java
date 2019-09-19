package zoo;
public class ZooKeeper {
	public void wake(Animals animal) {
		System.out.println("wake animals");
		animal.wakingUp();
	}
	
	public void rollCall(Animals animal) {
		System.out.println("Calling animals");
		animal.makeNoise();
	}
	
	public void feed(Animals animal) {
		System.out.println("feed animals");
		animal.eat();
	}
	
	public void exercise(Animals animal) {
		System.out.println("exercise animals");
		animal.roam();
	}
	
	public void shut(Animals animal) {
		System.out.println("Shut the zoo");
		animal.sleep();
	}
}
