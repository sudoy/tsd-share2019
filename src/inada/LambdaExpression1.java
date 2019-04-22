package inada;

import java.util.function.Predicate;

public class LambdaExpression1 {

	public static void main(String[] args) {

		Predicate<Integer> p1 = new Prd();
		System.out.println(p1.test(10));
		System.out.println(p1.test(-10));


		Predicate<Integer> p2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
//				if(t > 0) {
//					return true;
//				}else {
//					return false;
//				}
				return 0 < t;	//この1行で済む
			}
		};

		System.out.println(p2.test(10));
		System.out.println(p2.test(-10));

		Predicate<Integer> p3 = (Integer t) ->{
			if(t > 0) {
				return true;
			}else {
				return false;
			}
		};
		System.out.println(p3.test(10));
		System.out.println(p3.test(-10));

		Predicate<Integer> p4 = t ->{
			if(t > 0) {
				return true;
			}else {
				return false;
			}
		};
		System.out.println(p4.test(10));
		System.out.println(p4.test(-10));

	}

}

class Prd implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		if(t > 0) {
			return true;
		}else {
			return false;
		}
	}
}