package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		String s = "abba";
		
		char[] arr = s.toCharArray();
		
//        String[] arr = s.trim().split("");
//        System.out.println(Arrays.toString(arr));
        
        int count = 0;
        
        Map<String,Integer> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < arr.length; j++) {
            	
            	sb.append(arr[j]);
            	 String x=  sb.toString();
            	 char[] cArr =  x.toCharArray();
            	 Arrays.sort(cArr); 
            	 String y =  String.valueOf(cArr) ;
            	 
//            	 System.out.println(y); 
            	 
            	 if(hm.containsKey(y)) {
                 	System.out.println(y);    
                     count++;
                 } 
                 else {
                     hm.put(y,1);
                 }
                 
            	 
            	
//                list.add(arr[j]) ;
//                System.out.println(list); 
//                Collections.sort(list);
//                System.out.println(hm.containsKey(list)) ;
//                if(hm.containsKey(list)) {
//                	System.out.println(list);    
//                    count++;
//                } 
//                else {
//                    hm.put(list,1);
//                }
                
            }
        }
        System.out.println(hm);
        System.out.println(count); 
//        List<String> arr = ArrayList<String>();
        List<String> arr1 = new ArrayList<>();
        arr1.add("a") ;
        arr1.add("z") ;
        
        List<String> arr2 = new ArrayList<>();
        arr2.add("a");
        arr2.add("z");
        
        Map<List<String>, Integer> hm2 = new HashMap<>();
        hm2.put(arr1, 1);
        
        System.out.println(hm2.containsKey(arr2));
//        Map.Entry<List<String>, Integer > entry =  hm2.entrySet();   
        for(Map.Entry<List<String>, Integer> entry : hm2.entrySet()) {
        	System.out.println(entry.getKey() +"  "+ entry.getValue());
        }
		
        
        
	}
	
}
