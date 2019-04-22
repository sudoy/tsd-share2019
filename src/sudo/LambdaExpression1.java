package sudo;

import java.util.function.Predicate;

public class LambdaExpression1 {

	public static void main(String[] args) {
		// クラスを作る方法
		Predicate<Integer> p1 = new PredicateImpl();

		// 匿名クラスの方法
		Predicate<Integer> p2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return 0 < t;
			}
		};

		// ラムダ式（省略なし）
		Predicate<Integer> p3 = (Integer t) -> {
			return 0 < t;
		};

		// ラムダ式（省略あり）
		Predicate<Integer> p4 = t -> 0 < t;

		// 確認
		System.out.println(p2.test(10));
		System.out.println(p2.test(-10));
	}

}

class PredicateImpl implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return 0 < t;
	}
}

