import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		
		NumberFormat us=NumberFormat.getCurrencyInstance(Locale.US); 
		//we have to create a local for india as it is not saved in this 
		
		Locale IND = new Locale("en", "IN");
        NumberFormat i  = NumberFormat.getCurrencyInstance(IND);
        
		NumberFormat france=NumberFormat.getCurrencyInstance(Locale.FRANCE); 
		NumberFormat china=NumberFormat.getCurrencyInstance(Locale.CHINA);
		
		System.out.println(france.format(654645.654654));
		System.out.println(i.format(654645.654654));
		System.out.println("==============");
		
		List<String> list = new ArrayList<>();
		list.add("ram");
		System.out.println(list.contains("ram"));
		
		HashMap<String, Integer> hm = new LinkedHashMap<>();
		hm.put("vishal", 55);
		
		
		System.out.println(hm.get("vishal"));
		
//		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
//			if(list.contains(entry.getKey())) {
//				entry.getva
//			}
//		}
		
		
	} 
	
}
