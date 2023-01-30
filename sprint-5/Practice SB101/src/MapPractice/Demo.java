package MapPractice;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo {

	public static void main(String[] args) {
		
		Map<String, String> hm = new HashMap<>();
		
		hm.put("Maharashtra", "Mumbai");
		hm.put("Up", "Ayodhya");
		hm.put("Goa", "Panji");
		
//		for(Map.Entry<String, String> entry : hm.entrySet()) {
//			
//			System.out.println(entry.getKey() +"   "+ entry.getValue());
//			
//		}
		
		Map<Student, String> hm2 = new HashMap<>();
		
		hm2.put(new Student("Vishal", 23), "Maharashtra") ;
		hm2.put(new Student("Ajinkya", 234), "Pune");
		hm2.put(new Student("Zingya", 2), "UP");
		hm2.put(new Student("Mari", 987), "South");
		
		Set<Student> keySets  =  hm2.keySet();
		Collection<String> values =   hm2.values();
		
		Map<Student, String> treeMap = new TreeMap<Student, String>(new SortById());
		
		for(Map.Entry<Student, String> entry : hm2.entrySet()) {
			treeMap.put(entry.getKey(), entry.getValue());
		}

		for(Map.Entry<Student, String> entry : treeMap.entrySet()) {
			System.out.println(entry);
		}
		
		
		
	}
	
}

class SortById implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		if(s1.getRoll() > s2.getRoll()) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
	
	
}

class Student {
	private String name ;
	private int roll;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}
	
	
}
