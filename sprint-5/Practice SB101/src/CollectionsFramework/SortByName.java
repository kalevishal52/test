package CollectionsFramework;

import java.util.Comparator;

public class SortByName implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		
		return p1.getProductName().compareToIgnoreCase(p2.getProductName()) ;
	}

	
	
}
