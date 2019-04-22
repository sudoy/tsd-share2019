package yamamoto;

public class LambdaExpression3 {

	public static void main(String[] args) {
		System.out.println(new SummaryImpl().exec(10, 5));
		Summary s1 = new Summary() {
			@Override
			public int exec(int a, int b) {
				return a + b;
			}
		};
		Summary s2 = (int a, int b) ->{
			return a + b;
		};
		Summary s3 = (a,b) -> a + b;
		System.out.println(s1.exec(10, 5));
		System.out.println(s2.exec(10, 5));
		System.out.println(s3.exec(10, 5));
//		System.out.println(new Summary() {@Override public int exec(int a, int b) {return a + b;}}.exec(11, 3));
	}

}

interface Summary{
	public int exec(int a, int b);
}

class SummaryImpl implements Summary{
	@Override
	public int exec(int a, int b) {
		return a + b;
	}

}
