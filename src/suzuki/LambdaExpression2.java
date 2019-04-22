package suzuki;

public class LambdaExpression2 {

	public static void main(String[] args) {


		Summary s1 = new Summary() {
			public int exec(int a, int b) {
				return a + b;
			}
		};

		Summary s2 = (int a, int b) ->{
			return a + b;
		};

		Summary s3 = (a, b) -> a + b;

		System.out.println(new SummaryImpl().exec(10, 5));
		System.out.println(s1.exec(3, 12));
		System.out.println(s2.exec(1, 2));
		System.out.println(s3.exec(2, 4));
	}

}

interface Summary{
	public int exec(int a, int b);
}

class SummaryImpl implements Summary{
	public int exec(int a, int b) {
		return a + b;
	}
}
