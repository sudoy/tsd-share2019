package kobayashi;

public class LambdaExpression2 {

	public static void main(String[] args) {

		Summary a1 = new Summary() {
			@Override
			public int exec(int a, int b) {
				return a + b;
			}
		};

		Summary a2 = (int a, int b) -> {
			return a + b;
		};

		Summary a3 = (a, b) -> a + b;

		System.out.println(new SummaryImpl().exec(10, 5));
		System.out.println(a1.exec(2,6));
		System.out.println(a2.exec(1,4));
		System.out.println(a3.exec(6,8));



	}
}

class SummaryImpl implements Summary {
	@Override
	public int exec(int a, int b) {
		return a + b;
	}
}

interface Summary {
	public int exec(int a, int b);

}
