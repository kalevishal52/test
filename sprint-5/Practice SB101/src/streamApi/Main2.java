package streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

	public static void main(String[] args) {
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(13, 50, "Vishal")) ;
		studentList.add(new Student(1, 500, "Onkar")) ;
		studentList.add(new Student(11, 450, "Ajinkya")) ;
		studentList.add(new Student(15, 220, "Zingya")) ;
		studentList.add(new Student(10, 150, "Tenya")) ;
		
		
		List<Employee> empList =  studentList
										.stream()
										.map(s -> new Employee(s.getRoll(), s.getName(), s.getMarks()*1000))
										.collect(Collectors.toList()) ;
		
		empList.forEach(e -> System.out.println(e));
		
		
	}
	
}
