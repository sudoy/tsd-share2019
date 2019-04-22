package suzuki;

public class Sample8_3 {

	public static void main(String[] args) {

		LocalOuter outer = new LocalOuter();
		outer.method("param1", "param2");
	}

}

class LocalOuter{ //外部クラス

	private String outerVal = "outerVal";

	public void method(final String param1,String param2) {

		final int x = 10; //引数も変数も変更できない
		int y = 20;

		class LocalInner{ //ローカルクラス

			void method(){
				System.out.println("outerVal : "+ outerVal); //外部インスタンス変数
				System.out.println("x        : "+ x); //外部クラスのメソッドのローカル変数
				System.out.println("y        : "+ y);
				System.out.println("param1   : "+ param1);
				System.out.println("param2   : "+ param2);
			}
		}
		LocalInner inner = new LocalInner();
		inner.method();
		outerVal = "hello";
	}
}