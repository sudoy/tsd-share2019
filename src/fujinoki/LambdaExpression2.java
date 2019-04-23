package fujinoki;

interface Summary {
	public int exec(int a, int b);
}

public class LambdaExpression2 {

	public static void main(String[] args) {
		Summary s = new Summaryimpl();
		System.out.println(s.exec(10, 5));

		//ラムダ式(省略なし)
		Summary s1 = new Summary() {

			@Override
			public int exec(int a, int b) {

				return (a + b);
			}
		};
		System.out.println(s.exec(10, 5));

		//省略あり
		Summary s2 = (a,b) -> a + b;
		System.out.println(s.exec(10, 5));
	}

}

class Summaryimpl implements Summary {

	@Override
	public int exec(int a, int b) {

		return (a + b);
	}

}
