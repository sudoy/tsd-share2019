package kobayashi;

import java.util.function.Predicate;

public class LambdaExpression1 {

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
			if(t > 0) {
				return true;
			}else {
				return false;
			}
		};
		//省略
		Predicate<Integer> p4 = t -> 0 < t;


		System.out.println(p1.test(10));
		System.out.println(p1.test(-10));

		System.out.println(p2.test(10));
		System.out.println(p2.test(-10));

		System.out.println(p3.test(10));
		System.out.println(p3.test(-10));

		System.out.println(p4.test(10));
		System.out.println(p4.test(-10));
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



