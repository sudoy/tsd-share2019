package sudo;

import java.util.function.Predicate;

public class Test0422 {

	public static void main(String[] args) {
		// ラムダ式（省略なし）
		Predicate<Integer> pre1 = (Integer s) -> {
			return true;
		};

		// 匿名クラス
		Predicate<Integer> pre2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer s) {
				return true;
			}
		};

		// 確認
		System.out.println(pre1.test(10));
		System.out.println(pre1.test(-10));

		Hogehoge2 h = new Hogehoge2();
		System.out.println(h.test(10));
	}
}

class Hogehoge2{
	public boolean test(Integer i) {
//		return true; // iが正だったらtrue、iが負だったらfalse
		if(i < 0) {
			return false;
		} else {
			return true;
		}
	}
}
