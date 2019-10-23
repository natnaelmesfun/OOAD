package my_classes;
import java.util.HashMap;

public class rentalStore {
	
	// rental details
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	
	public HashMap<Integer, String> gethmap() {
        return this.hmap;
    }

    public void sethmap(HashMap hmap) {
        this.hmap = hmap;
    }
    
    public void addhmap(HashMap hmap, String Name, int id) {
    	hmap.put(Name, id);
    }

	
	//test data
	// variable of type String 
    public String s; 
  
    // private constructor restricted to this class itself 
    private rentalStore() 
    { 
        s = "Hello I am a string part of Singleton class"; 
    } 
	
	private static rentalStore uniqueInstance;
	
	
	public static rentalStore getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new rentalStore();
		}
		
		return uniqueInstance;
	}


	
;
}
