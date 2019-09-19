package zoo;
public class Main {
	public static void main (String args[]) {
		Animals catie = new Cat("Catie");
		Animals canny = new Cat("Canny");
		Animals lune = new Lion("Lune");
		Animals larry = new Lion("Larry");
		ZooKeeper john = new ZooKeeper();
		
//		store[0] = catie;
//		store[1] = canny;
//		store[2] = lune;
//		store[3] = larry;
	
		Animals[] store = {catie, canny, lune, larry};
		
		for(int i=0; i<store.length; i++) {
			john.wake(store[i]);
			john.rollCall(store[i]);
			john.feed(store[i]);
			john.exercise(store[i]);
			john.shut(store[i]);
		}
 		
		
		
	}
}
