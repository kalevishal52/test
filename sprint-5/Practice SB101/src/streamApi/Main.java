package streamApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(13, 50, "Vishal")) ;
		studentList.add(new Student(1, 500, "Onkar")) ;
		studentList.add(new Student(11, 450, "Ajinkya")) ;
		studentList.add(new Student(15, 220, "Zingya")) ;
		studentList.add(new Student(10, 150, "Tenya")) ;
		
//		Collections.sort(studentList, new SortByRoll());
		
		studentList.forEach(s -> System.out.println(s));
		
		System.out.println("==============================================");
		
//		Stream<Student> filteredStream =  studentList
//													.stream()
//													.sorted(new SortByRoll())
//													.filter(s -> s.getMarks() < 250) ;
//		filteredStream.forEach(s -> System.out.println(s));
		
		List<Student> filteredList = 
									studentList
										.stream()
										.sorted(new SortByRoll())
										.filter(s -> s.getMarks() < 250) 
										.collect(Collectors.toList()) ;
		filteredList.forEach(s -> System.out.println(s));
	}
	
}

class SortByRoll implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getRoll() > o2.getRoll() ? +1 : -1 ;
	}
	
}
