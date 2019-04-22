package yamamoto;

public class LambdaExpression1 {

	public static void main(String[] args) {
		Predicate p1 = new PredicateClass();
		Predicate p2 = new Predicate() {
			@Override
			public boolean test(int x) {
				return 0 < x;
			}
		};
		Predicate p3 = (int s) ->{
			return 0 < s;
		};
		Predicate p4 = s -> 0 < s;

		System.out.println(p1.test(1));
		System.out.println(p2.test(1));
		System.out.println(p3.test(1));
		System.out.println(p4.test(1));
	}

}

interface Predicate{
	boolean test(int x) ;
}

class PredicateClass implements Predicate{
	@Override
	public boolean test(int x) {
		return 0 < x;
	}
}

