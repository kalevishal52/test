package GenericsAndLambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void calculate(Calculator cal,int a,int b) {
		System.out.println(cal.calculate(a, b));
	}
	
	public static Calculator getCalculatorAdd() {
		return (a,b) -> a+b ;
	}

	public static void main(String[] args) {
		
		List<String> cities = new ArrayList<>();
		cities.add("Kurduwadi");
		cities.add("Bhosre");
		cities.add("Kurdu");
		cities.add("Madha");
		
		
		PrintList printList = city -> city.forEach(c -> System.out.println(c));;
		printList.display(cities);
		
		/*
		Calculator add = (a,b) -> a+b;
		Calculator multiply = (a,b) -> a*b;
		
		calculate(add, 8, 4);
		calculate((a,b)-> a-b, 8,4);
		
		Calculator c4 =  getCalculatorAdd();
		System.out.println(c4.calculate(9, 32));
		
//		PrintList pl = new Test();
//		pl.display(cities);
		
		Intr i1 = new Intr() {

			@Override
			public void sayHello(String name) {
				System.out.println(name);
			}	
		};

//		i1.sayHello("Vishal");
		
		Intr i2 = (name) -> System.out.println(name);
		i2.sayHello("Vishal Bahi");
		
		Intr i3 = name -> System.out.println(name);
		i3.sayHello("Vishal Dada");
		
		PrintList p3 = (List<String> city) -> city.forEach(c -> System.out.println(c));
		p3.display(cities);
		PrintList p2 = new PrintList() {
			@Override
			public void display(List<String> city) {
				city.forEach(c -> System.out.println(c));
			}
		};
		
		p2.display(cities);
		*/
		
		
//		Calculator add = (a,b) -> a+b;
//		Calculator multiply = (a,b) -> a*b;
		
//		System.out.println(add.calculate(7, 5));
//		System.out.println(multiply.calculate(9, 2));
	}
	
}

interface Calculator {
	public int calculate(int a, int b);
}


@FunctionalInterface
	interface Intr{
	void sayHello(String name);
}


class Test implements PrintList{

	@Override
	public void display(List<String> city) {
		city.forEach(c -> System.out.println(c));
	}
	
}

@FunctionalInterface
interface PrintList {
	abstract void display(List<String> city);
}