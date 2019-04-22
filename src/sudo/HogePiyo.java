package sudo;

public class HogePiyo {
	public static void main(String[] args) {
		// インタフェースをもっと簡単にnewしよう！ -> 匿名クラス
		// 普通のやり方
		Int i1 = new IntImpl();

		Int i2 = new Int() {

		};

	}
}

class IntImpl implements Int{
	@Override
	public void method() {
		System.out.println("hogehoge");
	}
}
