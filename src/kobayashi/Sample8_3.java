package kobayashi;

public class Sample8_3 {

	public static void main(String[] args) {
		LocalOuter outer  = new LocalOuter();
		outer.method("param1","param2");

	}

}
class LocalOuter{//外部クラス
	private String outerVal = "outerVal";

	public void method(final String param1,String param2) {
		final int x = 10;
		int y = 20;

		//ローカルクラスの定義
		class LocalInner{
			void method() {
				System.out.println("outerVal : " + outerVal);
				System.out.println("x        : " + x);
				System.out.println("y        : " + y);

				System.out.println("param1   : " + param1);
				System.out.println("param2   : " + param2);
			}
		}
		LocalInner inner = new LocalInner();
		inner.method();
		outerVal = "hello";//LocalOuterクラスのインスタンス変数は変更してもエラーが出ない
		//y = 10;
		//parma2 = "hello";
	}
}
