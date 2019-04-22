package yamamoto;

public class Sample8_4_1 {

	public static void main(String[] args) {
		Int i1 = new IntInmpl();
		i1.method();

		Int i2 = new Int() {
			@Override
			public void method() {
				System.out.println("piyopiyo");
			}
		};
		i2.method();
	}
}
class IntInmpl implements Int{
	@Override
	public void method() {
		System.out.println("hegehoge");
	}

}
interface Int {
	public abstract void method();
}
