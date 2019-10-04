package my_classes;

public class Zookeeper {
	
	public Zookeeper() {
		
	}
	
	public void wake_animals(Animals animals, String Name) {
		System.out.println("Zookeeper waking up animals.");
		System.out.println("My type is " + animals.getClass());
		animals.wake_up(Name);
	}
	
	public void rollcall_animals(Animals animals, String Name) {
		System.out.println("Zookeeper roll calling animals.");
		
		animals.wake_up(Name);
		animals.eat(Name);
		animals.sleep(Name);
	
	}
	
	public void feed_animals(Animals animals, String Name) {
		System.out.println("Zookeeper feeding animals.");
		
		animals.eat(Name);
	}
	
	public void exercise_animals() {
		System.out.println("Zookeeper exercing animals.");
	}
	
	public void shutdown_zoo() {
		System.out.println("Zookeeper shuting down zoo.");
	}

}
