package my_classes;

public class Lion extends Feline{
	public Lion() {
		
	}
	
	public void roam() {
		System.out.println("Roaming");
	}
	
	public int number_generator(Lion animal) {
		if (animal != null) {
//			Method[] methods = new ArrayList();
//	        Method[] methods = animal.getClass().getDeclaredMethods();
			System.out.println(animal.getClass().getDeclaredMethods().length);
			
			//generate random number from the size
	        return animal.getClass().getDeclaredMethods().length;
	    }
		else {
			return 0;
		}
		
	}
}
