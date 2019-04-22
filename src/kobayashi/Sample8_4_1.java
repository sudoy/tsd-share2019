package kobayashi;

public class Sample8_4_1 {
	public static void main(String[] args) {

		//普通のやり方
		Int i1 = new IntImpl();
		i1.method();

		//匿名クラス
		Int i2 = new Int() {
			@Override
			public void method() {
				System.out.println("hogehoge");
			}
		};
		i2.method();
	}
}
class IntImpl implements Int{
	@Override
	public void method() {
		System.out.println("hogeohge");
	}
}
interface Int{
	public abstract void method();
}
