package inada;

public class Sample8_4_1 {

	public static void main(String[] args) {
		Int i1 = new IntImpl();
		i1.method();

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
		System.out.println("hogehoge");
	}

}

interface Int{
	public abstract void method();
}