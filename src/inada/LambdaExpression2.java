package inada;

public class LambdaExpression2 {

	public static void main(String[] args) {
		Summary s1 = new SummaryImpl();
		System.out.println(s1.exec(10, 5));

		Summary s2 = new Summary(){
			@Override
			public int exec(int a, int b) {
				return a + b;
			}
		};
		System.out.println(s2.exec(10, 5));

		Summary s3 = (int a, int b) -> {
			return a + b;
		};
		System.out.println(s3.exec(10, 5));

		Summary s4 = (a, b) -> a + b;
		System.out.println(s4.exec(10, 5));
	}

}

class SummaryImpl implements Summary{

	@Override
	public int exec(int a, int b) {
		return a + b;
	}

}

interface Summary{
	public int exec(int a, int b);
}