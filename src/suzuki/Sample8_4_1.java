package suzuki;

public class Sample8_4_1 {

	public static void main(String[] args) {

		Int i1 = new IntImpl(); // 普通のやり方
		i1.method();

		Int i2 = new Int() { //匿名クラス
			@Override
			public void method() {
				System.out.println("hogehoge");
			}
		}; //注意
		i2.method();
	}

}

class IntImpl implements Int{

	@Override
	public void method() {
		System.out.println("hogehoge");
	}
}

interface Int{
	public abstract void method();
}
