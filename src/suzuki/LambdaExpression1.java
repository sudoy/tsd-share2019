package suzuki;

import java.util.function.Predicate;

public class LambdaExpression1 {

	public static void main(String[] args) {

		Predicate<Integer> x1 = new Pre();

		Predicate<Integer> x2 = (Integer t) -> {
			boolean b = t > 0;
			return b;
		};

		Predicate<Integer> x3 = t -> {
			boolean b = t > 0;
			return b;
		};

		Predicate<Integer> x4 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				boolean b = t > 0;
				return b;
			}
		};
		System.out.println(x1.test(2));
		System.out.println(x2.test(12));
		System.out.println(x3.test(-3));
		System.out.println(x4.test(0));

	}

}
class Pre implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		boolean b = t > 0;
		return b;
	}
}

