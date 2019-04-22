package suzuki;

import java.util.function.Predicate;

public class LambdaExpression1 {

	public static void main(String[] args) {

		Predicate<Integer> x1 = new Pre();

		Predicate<Integer> x2 = (Integer t) -> {
			return t.equals(t > 0);
		};

		Predicate<Integer> x3 = t -> t.equals(t > 0);

		Predicate<Integer> x4 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t.equals(t > 0);
			}
		};


	}

}
class Pre implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t.equals(t > 0);
	}
}

