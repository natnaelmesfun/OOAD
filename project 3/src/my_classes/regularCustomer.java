package my_classes;
import java.util.Random;

public class regularCustomer implements customerStrategy {
	
	Random rand = new Random();
	
	public String getName(String name) {
		return name;
	}
	
	public int chooseTools(int numTool_one, int numTool_two) {
		int c = rand.nextInt(3)+1;
		
		return c;
	}
}
