package yoshida;

public class LambdaExpression2 {

	public static void main(String[] args) {
		SummaryImpl s1 = new SummaryImpl() ;
		System.out.println(s1.exec(10, 5));


		Summary s2 = new Summary() {
			@Override
			public int exec(int a, int b) {
				return a + b;
			}
		};
		System.out.println(s2.exec(5,10));


		Summary s3 = (int a,int b)->{
			return a + b ;
		};
		System.out.println(s3.exec(5, 10));


		Summary s4 = (int a, int b)-> a + b;
		System.out.println(s4.exec(5, 10));
	}
}

class SummaryImpl implements Summary{

	@Override
	public int exec(int a, int b) {
		return a + b ;
	}
}

interface Summary{
	public int exec(int a, int b);
}

