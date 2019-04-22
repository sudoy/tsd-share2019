package sudo;

public class HelloWorld {

	public static void main(String[] args) {
		// new
		// メソッド呼び出し
//		Test t = new Test();
//		t.method(); // -> 異常終了

		int[] a = {1};
		System.out.println(a.toString());

	}
}

class Test{
	void method () throws Exception{
		Hogehoge h = new Hogehoge();
		h.hoge(); // 呼び出し元 -> ArithmeticExceptionがスローされた
		h.piyo(h);
	}
}

class Hogehoge{
	void hoge() throws Exception{
		System.out.println(15 / 0); // 例外
		System.out.println(15 - 0);
	}
	void piyo(Hogehoge h) {

	}
}