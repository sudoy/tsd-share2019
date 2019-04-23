package fujinoki;


import java.util.function.Predicate;

public class LambdaExpression1 {

	public static void main(String[] args) {
		Predicate<Integer> p1= new Predicateimpl();
		System.out.println(p1.test(1));
		System.out.println(p1.test(-1));


		//匿名クラスの方法
		Predicate<Integer>p2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				if(t < 0) {
					return false;
				}else {
					return true;
				}
			}
		};
		System.out.println(p2.test(1));
		System.out.println(p2.test(-1));


		//ラムダ式（省略なし）
		Predicate<Integer>p3 = (Integer t) ->{
			if(t < 0) {
				return false;
			}else {
				return true;
			}
		};
		System.out.println(p3.test(1));
		System.out.println(p3.test(-1));
		
		
		//ラムダ式（省略あり）
		Predicate<Integer> p4 = t -> 0 < t;
		System.out.println(p4.test(1));
		System.out.println(p4.test(-1));
	}
	
}

class Predicateimpl implements Predicate<Integer>{
	@Override
	public boolean test(Integer t) {
		if(t < 0) {
			return false;
		}else {
			return true;
		}
	}
}
