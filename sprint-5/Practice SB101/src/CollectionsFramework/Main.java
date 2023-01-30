package CollectionsFramework;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Product[] productArr = new Product[4];
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Enter product Id");
			int id = input.nextInt();
			
			System.out.println("Enter product Name");
			String name = input.next();
			
			System.out.println("Enter product Price");
			int price = input.nextInt();
			
			Product p = new Product(id, name, price);
			productArr[i] = p;
			
			System.out.println("=============================");
		}
		
		TreeSet<Product> productTreeSet = null ;
		
		System.out.println("ENter 1 to sort by Price 2 for sort by Name 3for Id");
		int res = input.nextInt();
		
		if(res == 1) {
			productTreeSet = new TreeSet<>(new SortByPrice());
		} else if(res == 2) {
			productTreeSet = new TreeSet<>(new SortByName());
		}
		
		for(Product p : productArr) {
			productTreeSet.add(p);
		}
		
		productTreeSet.forEach(p -> System.out.println(p));
		
		
	}
	
}
