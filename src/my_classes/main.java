package my_classes;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion Luke = new Lion();
		Lion Lebron = new Lion();
		Lion Levi = new Lion();
		
		Zookeeper Zack = new Zookeeper();
		
		Zack.wake_animals(Luke, "Luke");
		Zack.wake_animals(Lebron, "Lebron");
		Zack.wake_animals(Levi, "Levi");
		
		Levi.number_generator(Levi);	
		
	}

}
