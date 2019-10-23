package my_classes;
import java.util.Random;

public class businessCustomer implements customerStrategy {
	
	Random rand = new Random();
	
	public String getName(String name) {
		return name;
	}
//	
//	public int chooseTools_bussines(int numTool_one) {
//		return numTool_one;
//	}
	public int chooseTools(int numTool_one, int numTool_two) {
		int c = rand.nextBoolean() ? numTool_one : numTool_two;
		
		return c;
	}
}
