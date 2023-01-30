package evaluationOne;

import java.util.*;

public class Mobile {

	HashMap<String,ArrayList<String>> mobiles = new HashMap<>();
	
	public String addMobile(String company, String model) {
		String res = "Mobile added Sucessfully";
		
		if(mobiles.containsKey(company)) {
			
			mobiles.get(company).add(model);
			
		} else {
			ArrayList<String> arrList = new ArrayList<>();
			arrList.add(model);
			mobiles.put(company, arrList);	
		}
		
		return res;
	}
	
	public List<String> getModels(String company)throws InvalidMobileException {
		List<String> list = null ;
		
		if(mobiles.containsKey(company)) {
			
			list = mobiles.get(company) ;
			
		} else {
			throw new InvalidMobileException("Please Enter correct Company name");
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		Mobile mobileObj = new Mobile() ;

		System.out.println(mobileObj.addMobile("Apple", "iphone12"));
		System.out.println(mobileObj.addMobile("Apple", "iphone14")); 
		System.out.println(mobileObj.addMobile("Apple", "iphone15"));

		System.out.println(mobileObj.addMobile("Samsung", "s10")); 
		System.out.println(mobileObj.addMobile("Samsung", "s11")); 
		System.out.println(mobileObj.addMobile("Samsung", "s14"));
		
		System.out.println("__________________________________");
		
		try {
			List<String> modelsList =  mobileObj.getModels("Apple") ;
			modelsList.forEach(m -> System.out.println(m));
		} catch (InvalidMobileException e) {
			e.printStackTrace();
		}
		
	}
	
}
