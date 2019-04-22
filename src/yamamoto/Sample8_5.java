package yamamoto;

import java.util.function.Predicate;

public class Sample8_5 {

	public static void main(String[] args) {
		Predicate<String> pre = (String t) ->{
			return t.equals("Hello");
		};
//		Predicate<String> pre = t -> t.equals("Hello");
		System.out.println(pre.test("Hello"));
		System.out.println(pre.test("1"));

//		Predicate<String> pre1 = new Predicate<String>() {
//			@Override
//			public boolean test(String t) {
//				return t.equals("Hello");
//			}
//		};
//		System.out.println(pre1.test("Hello"));
//		System.out.println(pre1.test("1"));
	}
}
