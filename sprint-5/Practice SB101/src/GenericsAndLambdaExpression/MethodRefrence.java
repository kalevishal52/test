package GenericsAndLambdaExpression;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;

public class MethodRefrence {
	
	public static void sayHelloFromMethod(String n) {
		System.out.println("Saiying hello form method of Class MethodRefrence : " + n);
	}
	public static int convertStringToNumber(String str) {
		return Integer.parseInt(str);
	}

	public static void main(String[] args) {

//		sayHelloFromMethod("Vishal");
//		InterfaceSayHello intr = MethodRefrence::sayHelloFromMethod;
//		intr.sayHello("Data Vishal");
		
		IntrConvert convert = MethodRefrence::convertStringToNumber;
		System.out.println(convert.convertToNumber("654654") + 354654);
		
		IntrConvert convert2 = Integer::parseInt;
		System.out.println(convert2.convertToNumber("654654") - 100000);
		
		List<Statement> students=new ArrayList<>();
//		students.removeif
		
	}
}

@FunctionalInterface
interface InterfaceSayHello {
	public void sayHello(String n);
}

@FunctionalInterface
interface IntrConvert{
	int convertToNumber(String number);
}