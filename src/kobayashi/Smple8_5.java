package kobayashi;

import java.util.function.Predicate;

public class Smple8_5 {

	public static void main(String[] args) {
		//Predicate<String> pre = (String t) ->{
			//return t.contentEquals("Hello");
		Predicate<String> pre = t -> t.equals("hello");

		//};
		System.out.println(pre.test("Hello"));
		System.out.println(pre.test("1"));
	}
}
