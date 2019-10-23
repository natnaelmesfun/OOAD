package my_classes;
import java.util.*;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// instantiating Singleton class with variable x 
        rentalStore my_store = rentalStore.getInstance(); 
        
        System.out.println("String from x is " + my_store.s);
        
        //Record map
        Map<String, Integer> all_records_date = new HashMap<String, Integer>();
        Map<String, Integer> all_rented_days = new HashMap<String, Integer>();
        Map<String, ArrayList<String>> all_records_tools = new HashMap<String, ArrayList<String>>();
        
        
        
        //create customers
        customerContex contex_casual = new customerContex(new casaulCustomer());
        customerContex contex_business = new customerContex(new businessCustomer());
        customerContex contex_regular = new customerContex(new regularCustomer());
        
        Map<String, Integer> casual_customers = new HashMap<String, Integer>();
        List<String> casual_names = Arrays.asList("BruceCasul", "JoshCasul", "RosaCasul", "NateCasul");
        
        Map<String, Integer> bussines_customers = new HashMap<String, Integer>();
        List<String> bussines_names = Arrays.asList("BlakeBuss", "JohnBuss", "MikeBuss", "JoeBuss");
        
        Map<String, Integer> regular_customers = new HashMap<String, Integer>();
        List<String> regular_names = Arrays.asList("BobReg", "RickyReg", "RonReg", "PhilReg");

        
        
//        System.out.println(orangePaint.getTool("paint1"));
        
        my_store.addhmap(my_store.gethmap(), my_store.s, 5);
        
        ArrayList<String> Paint_arr = new ArrayList<String>();
        ArrayList<String> Concrete_arr = new ArrayList<String>();
        ArrayList<String> Yardwork_arr = new ArrayList<String>();
        ArrayList<String> Plumbing_arr = new ArrayList<String>();
        ArrayList<String> Woodwork_arr = new ArrayList<String>();

        // Create list of tools
        for (int count = 0; count <= 4; count++){
        	
        	ShapeTools shapeTools = new ShapeTools();
            Tools Paint = shapeTools.getTools("Paint");
            Tools Concrete = shapeTools.getTools("Concrete");
            Tools Yardwork = shapeTools.getTools("Yardwork");
            Tools Plumbing = shapeTools.getTools("Plumbing");
            Tools Woodwork = shapeTools.getTools("Woodwork");
            
            Paint_arr.add(Paint.getTool("Paint"+count));
            Concrete_arr.add(Concrete.getTool("Concrete"+count));
            Yardwork_arr.add(Yardwork.getTool("Yardwork"+count));
            Plumbing_arr.add(Plumbing.getTool("Plumbing"+count));
            if(count != 4) {
            	Woodwork_arr.add(Woodwork.getTool("Woodwork"+count)); 
            }
              
            
        	
        }
        
        ArrayList<ArrayList<String>> allTools = new ArrayList<ArrayList<String>>();
        allTools.add(Paint_arr);
        allTools.add(Concrete_arr);
        allTools.add(Yardwork_arr);
        allTools.add(Plumbing_arr);
        allTools.add(Woodwork_arr);
        
        ArrayList<String> toolsReference = new ArrayList<>(Arrays.asList("Paint", "Concrete", "Yardwork", "Plumbing", "Woodwork"));
        ArrayList<Integer> toolsPrices = new ArrayList<>(Arrays.asList(15, 30, 45, 50, 20));
        

        System.out.println("allTools: "+ allTools);
        
        int Total_money_all = 0;
        int total_rented_casual = 0;
        int total_rented_bus = 0;
        int total_rented_reg = 0;
        //Start main program 
        for (int days = 1; days < 36; days++){
        	
        	int Totalamount = 0;
        	
        	for (int x = 0; x < 4; x++){
//            	System.out.println(casual_names.get(x));
            	casual_customers.put(contex_casual.executeName(casual_names.get(x)), contex_casual.excute_chooseTools(1, 2));
            	bussines_customers.put(contex_business.executeName(bussines_names.get(x)), contex_business.excute_chooseTools(3, 3));
            	regular_customers.put(contex_regular.executeName(regular_names.get(x)), contex_regular.excute_chooseTools(1, 3));
            }

        	System.out.println("DAY: "+ days);
        	
        	//Return rented tools if their due date is due
        	for(String key : all_records_date.keySet()) {
        		
        		int rented_date = all_rented_days.get(key); //day they rented tools
        		int rent_time = all_records_date.get(key); //max rent time
        		int date_difference = days - rented_date;
        		
        		if(rented_date == 0) {
        			continue;
        		}
        			
        		if(date_difference == rent_time) {

//        			System.out.println("Customer: " + key);
//        			System.out.println("Record: " + all_records_tools);
        			
        			ArrayList<String> tools_to_return = new ArrayList<String>(all_records_tools.get(key));
//        			System.out.println("Tools to return: " + tools_to_return);
        			String toolType_num = tools_to_return.get(0);
        			String toolType = toolType_num.substring(0, toolType_num.length() - 1);
        			
					//Set rented day to 0 when their about to return tools
        			all_rented_days.replace(key, 0);
//        			all_records_tools.get(key).remove();
        			
        			//Adding tools back
        			for (int m = 0; m < toolsReference.size(); m++){
        				
        				if(toolType.equals(toolsReference.get(m))) {
        					
        					for(int t = 0; t < tools_to_return.size(); t++) {
        						
//        						System.out.println("Adding back tools to the main Tools Array");
        						
        						allTools.get(m).add(tools_to_return.get(t));
        						
     
        						
        					}
        					
        					
        					break;
        				}
        				else {
        					continue;
        				}
        				
        				
        			}
        			
        			
        			
        		}
        		
        		
        	}
        	
        	System.out.println("Remaining tools after customers return tools: " + allTools);
        	
        	
        	
        	//Checking if there is tools in the store
        	int hasObject = 0;
        	for(int l = 0; l < allTools.size(); l++) {
        		ArrayList<String> subList = new ArrayList<String>(allTools.get(l));
        		if(subList.isEmpty()) {
        			continue;
        		}
        		else {
        			hasObject++;
        		}
        	}
        	
//        	System.out.println("hasObject: "+ hasObject);
        	
        	
        	//RENTING SECTION
        	if(hasObject == 0) {
        		System.out.println("No tools!");
        	}
        	else {
        		
        		int num_max_cust_day = 4;
        		Random rand = new Random();
        		
        		int ran_num_casual = rand.nextInt(num_max_cust_day)+1;
        		int ran_num_bussines = rand.nextInt(num_max_cust_day)+1;
        		int ran_num_regular = rand.nextInt(num_max_cust_day)+1;
        		
        		int Totalcustomers = ran_num_casual + ran_num_bussines + ran_num_regular;
        		
//        		System.out.println("Total customers per day: " + Totalcustomers);
        		
        		//Number of categories
        		int num_categories = 5;
        		
        		
        		//Iterate over Customers based on the number of customers and rent tools
//        		System.out.println("Casual Customers: " + ran_num_casual);
        		int count_casual = 0;
        		for (Map.Entry<String, Integer> entry : casual_customers.entrySet()) {

        			if(count_casual < ran_num_casual) { //how many casual customers per day
        				
        				String key = entry.getKey();
        				int value = entry.getValue();
        				
        				String name_casual = key;
        				int num_rent_casual = value;
        				
        				//Allow every customer to rent			
        				//Loop over Tool Tracker List
        				for (ArrayList<String> innerList : allTools) {
        					
      						ArrayList<String> tools_rented_casual = new ArrayList<String>();
      						int count_rented_casual = 0; 
      						
        					if(innerList.size() >= value) {     						
        						for (int j = 0; j < value; j++) {
        							//Append to tools rented
        							if(innerList.size() == 0 || count_rented_casual == value || 
        									(all_records_date.containsKey(key) && !all_rented_days.get(key).equals(0))) {
        								break;
        							}
        							else {
        								int rand_tool_casual = rand.nextInt(innerList.size());
        								//System.out.println("rand_tool_casual: " + rand_tool_casual);
	        							tools_rented_casual.add(innerList.get(rand_tool_casual));
	        							
	        							
	        							        				
	        							innerList.remove(rand_tool_casual);
	        							j--; //bc size of list changes when we remove item
	        							count_rented_casual++;
        							}
        						
        							
        						}
        						
        						
        						
        	        			
        	        			if(!tools_rented_casual.isEmpty()) {
        	        				
        	        				String toolTypecasual = tools_rented_casual.get(0);
            	        			String toolTypecas = toolTypecasual.substring(0, toolTypecasual.length() - 1);
            	        			
            	        			int price_cas = 0;
            	        			for (int m = 0; m < toolsReference.size(); m++){
            	        				if(toolTypecas.equals(toolsReference.get(m))) {
            	        					price_cas = tools_rented_casual.size() * toolsPrices.get(m);
            	        				}
            	        			}
            	        			
            	        			Totalamount += price_cas;
            	        			total_rented_casual += tools_rented_casual.size();
        							System.out.println(key + " rented: " + tools_rented_casual + 
        									" Day length of rent time: " + num_rent_casual + " Price: $" + price_cas);
        						}
    
        					}
        					else {
        						continue;
        					}
        					
        					
        					if (!all_records_date.containsKey(key) && !tools_rented_casual.isEmpty()){
    							all_records_tools.put(key, tools_rented_casual);
    							all_records_date.put(key, 2);
    							all_rented_days.put(key, days);
        					}
        					else if(all_rented_days.get(key).equals(0) && !tools_rented_casual.isEmpty()) {
        					
								all_records_tools.replace(key, tools_rented_casual);
								all_records_date.replace(key, 2);
								all_rented_days.replace(key, days);
							}
        					else {
        						count_casual--;
        					}

        					
        					break;
        				}
        				count_casual++;

        			}
        			else {
        				break;
        			}
        			
        		}
        		
//        		System.out.println("Bussines Customers: " + ran_num_bussines);
        		int count_bussines = 0;
        		for (Map.Entry<String, Integer> entry : bussines_customers.entrySet()) {
  
        			if(count_bussines < ran_num_bussines) {
        				String key = entry.getKey();
        				int value = entry.getValue();
        				
        				String name_bussines = key;
        				int num_rent_bussines = value;
        				
        				//Loop over Tool Tracker List
        				for (ArrayList<String> innerList : allTools) {
    						ArrayList<String> tools_rented_bussines = new ArrayList<String>();
    						int count_rented_bussines = 0;

        					if(innerList.size() >= num_rent_bussines) {
    
        						for (int j = 0; j < num_rent_bussines; j++) {
        							
        							if(innerList.size() == 0 || count_rented_bussines == num_rent_bussines || 
        									(all_records_date.containsKey(name_bussines)) && !all_rented_days.get(name_bussines).equals(0)){
        								break;
        							}
        							else {
        								int rand_tool_bussines = rand.nextInt(innerList.size());
        								tools_rented_bussines.add(innerList.get(rand_tool_bussines));
	        							        				
	        							innerList.remove(rand_tool_bussines);
	        							j--; //bc size of list changes when we remove item
	        							count_rented_bussines++;
        							}						
        						}
        						if(!tools_rented_bussines.isEmpty()) {
        							String toolTypecasual = tools_rented_bussines.get(0);
            	        			String toolTypecas = toolTypecasual.substring(0, toolTypecasual.length() - 1);
            	        			
            	        			int price_bus = 0;
            	        			for (int m = 0; m < toolsReference.size(); m++){
            	        				if(toolTypecas.equals(toolsReference.get(m))) {
            	        					price_bus = tools_rented_bussines.size() * toolsPrices.get(m);
            	        				}
            	        			}
            	        			
            	        			Totalamount += price_bus;
            	        			total_rented_bus += tools_rented_bussines.size();
            	        			
            	        			System.out.println(key + " rented: " + tools_rented_bussines + 
        									" Day length of rent time: " + num_rent_bussines+ " Price: $" + price_bus);
        						}
        					}
        					else {
        						continue;
        					}
        					
        					
        					if (!all_records_date.containsKey(name_bussines) && !tools_rented_bussines.isEmpty()){
            					all_records_tools.put(name_bussines, tools_rented_bussines);
            					all_records_date.put(name_bussines, 7);
            					all_rented_days.put(name_bussines, days);
                			}
                			else if(all_rented_days.get(name_bussines).equals(0) && !tools_rented_bussines.isEmpty()) {
        						all_records_tools.replace(name_bussines, tools_rented_bussines);
        						all_records_date.replace(name_bussines, 7);
        						all_rented_days.replace(name_bussines, days);
        					}
                			else {
                				count_bussines--;
        					}
        					
        					break;
        				}
        				count_bussines++;
        			}
        			else {
        				break;
        			}
        			
        		}
        		
//        		System.out.println("Regular Customers: " + ran_num_regular);
        		int count_regular = 0;
        		for (Map.Entry<String, Integer> entry : regular_customers.entrySet()) {
   
        			if(count_regular < ran_num_regular) {
        				String key = entry.getKey();
        				int value = entry.getValue();
        				
        				String name_regular = key;
        				int num_rent_regular = value;
        				
        				//Loop over Tool Tracker List
        				for (ArrayList<String> innerList : allTools) {
    						ArrayList<String> tools_rented_regular = new ArrayList<String>();
    						int count_rented_regular = 0;
        
        					if(innerList.size() >= num_rent_regular) {
        						for (int j = 0; j < num_rent_regular; j++) {
        							
        							if(innerList.size() == 0 || count_rented_regular == num_rent_regular || 
        									(all_records_date.containsKey(name_regular) && all_rented_days.get(name_regular).equals(0))) {
        								break;
        							}
        							else {
        								int rand_tool_regular = rand.nextInt(innerList.size());
        								tools_rented_regular.add(innerList.get(rand_tool_regular));
	        							        				
	        							innerList.remove(rand_tool_regular);
	        							j--; //bc size of list changes when we remove item
	        							count_rented_regular++;
        							}		

        						}
        						if(!tools_rented_regular.isEmpty()) {
        							String toolTypecasual = tools_rented_regular.get(0);
            	        			String toolTypecas = toolTypecasual.substring(0, toolTypecasual.length() - 1);
            	        			
            	        			int price_reg = 0;
            	        			for (int m = 0; m < toolsReference.size(); m++){
            	        				if(toolTypecas.equals(toolsReference.get(m))) {
            	        					price_reg = tools_rented_regular.size() * toolsPrices.get(m);
            	        				}
            	        			}
            	        			
            	        			Totalamount += price_reg;
            	        			total_rented_reg += tools_rented_regular.size();
            	        			
            	        			System.out.println(key + " rented: " + tools_rented_regular + 
        									" Day length of rent time: " + num_rent_regular+ " Price: $" + price_reg);
        						}
        					}
        					else {
        						continue;
        					}
        					
        					if (!all_records_date.containsKey(name_regular) && !tools_rented_regular.isEmpty()){
            					all_records_tools.put(name_regular, tools_rented_regular);
            					all_records_date.put(name_regular, 3);
            					all_rented_days.put(name_regular, days);
                			}
                			else if(all_rented_days.get(name_regular).equals(0) && !tools_rented_regular.isEmpty()) {
        						all_records_tools.replace(name_regular, tools_rented_regular);
        						all_records_date.replace(name_regular, 3);
        						all_rented_days.replace(name_regular, days);
        					}
                			else {
                				count_regular--;
        					}
        					
        					break;
        					

        				}
        				count_regular++;
        			
        			}else {
		    				break;
		    		}
        			
        			
        		}
     
        	}

        	Total_money_all += Totalamount;
        	System.out.println("Total amount made for the day: $" + Totalamount);
        	
        	System.out.println("Remaining tools in the rental store: " + allTools);
        	
        	System.out.println("\n");
        }
        
        System.out.println("Total amount made out of 35 days: $" + Total_money_all);
        System.out.println("Total number of tools rented by causual customers: " + total_rented_casual);
        System.out.println("Total number of tools rented by bussines customers: " + total_rented_bus);
        System.out.println("Total number of tools rented by regular customers: " + total_rented_reg);
        
	}

}
