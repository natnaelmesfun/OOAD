package my_classes;

public class customerContex {
	
	private customerStrategy customerstrategy;

	public customerContex(customerStrategy customerstrategy){
	      this.customerstrategy = customerstrategy;
	   }

	   
	public String executeName(String name) {
		return customerstrategy.getName(name);
	}
		
	
	public int excute_chooseTools(int numTool_one, int numTool_two) {
		
		return customerstrategy.chooseTools(numTool_one, numTool_two);
	}
	
//	public int excute_numTools_one(int numTool_one) {
//		return customerstrategy.numTools_one(numTool_one);
//	}
//		
//	public int excute_numTools_two(int numTool_two) {
//		return customerstrategy.numTools_two(numTool_two);
//	}
}
