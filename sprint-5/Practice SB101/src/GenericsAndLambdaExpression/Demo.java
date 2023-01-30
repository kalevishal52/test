package GenericsAndLambdaExpression;

public class Demo {

	public static void main(String[] args) {

		
		MyGenerics<Integer> m2 = new MyGenerics<>();
		m2.add(234);
		System.out.println(m2.get());
	}
	
}

class MyGenerics<T> {
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return obj;
	}
}