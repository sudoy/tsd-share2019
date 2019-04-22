package yoshida;
import java.util.function.Predicate;
public class LambdaExpression1 {

	public static void main(String[] args) {
		Impl i1 = new Impl();
		System.out.println(i1.test(10));
		System.out.println(i1.test(-10));


		Predicate<Integer> pre1 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				if(0 > t) {
					return false ;
				}else {
					return true;
				}
			}
		};

		System.out.println(pre1.test(10));
		System.out.println(pre1.test(-10));

		Predicate <Integer> pre2 = (Integer x) -> {
			if(0 > x) {
				return false;
			}else {
				return true;
			}
		};

		System.out.println(pre2.test(10));
		System.out.println(pre2.test(-10));

		Predicate <Integer> pre3 = y -> {
			if(0 > y) {
				return false ;
			}else {
				return true ;
			}
		};
		System.out.println(pre3.test(10));
		System.out.println(pre3.test(-10));
	}
}


class Impl implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		if(0 > t) {
			return false ;
		}else {
			return true;
		}

	}
}