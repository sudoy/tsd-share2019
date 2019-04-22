package yamamoto;

import java.util.function.Predicate;

public class LambdaExpression1 {

	public static void main(String[] args) {
		Predicate<Integer> p1 = new PredicateClass();
		Predicate<Integer> p2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return 0 < x;
			}
		};
		Predicate<Integer> p3 = (Integer s) ->{
			return 0 < s;
		};
		Predicate<Integer> p4 = s -> 0 < s;

		System.out.println(p1.test(1));
		System.out.println(p2.test(1));
		System.out.println(p3.test(1));
		System.out.println(p4.test(1));
	}

}

class PredicateClass implements Predicate<Integer>{
	@Override
	public boolean test(Integer t) {
		return 0 < t;
	}

}

