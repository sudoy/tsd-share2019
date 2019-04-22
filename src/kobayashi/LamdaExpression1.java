package kobayashi;

import java.util.function.Predicate;

public class LamdaExpression1 {

	public static void main(String[] args) {

		Predicate<Integer> p1 = new PredicateImpl();

		Predicate<Integer> p2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				if(t > 0 ) {
					return true;
				}else{
					return false;
				}
			}
		};
		//ラムダ式(省略なし)
		Predicate<Integer>p3 = (Integer t) ->{
			if(t < 0) {
				return true;
			}else {
				return false;
			}
		};

		Predicate<Integer> p4 = t -> 0 < t;


		System.out.println(p2.test(1));
		System.out.println(p2.test(-10));

		Predicate<Integer> a1 = (Integer x) ->{
			if(x < 0) {
				return true;
			}else {
			return false;
			}
		};
		System.out.println(p1.test(1));
		System.out.println(p1.test(-10));
	}
}
class PredicateImpl implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		if(t > 0 ) {
			return true;
		}else{
			return false;
		}
	}
}



