package yamamoto;

public class Sample7_5 {

	public static void main(String[] args) {
		double x = 15.0;
		double y = 0.0;
		try {
			Sample7_5 obj = new Sample7_5();
			double z = obj.doubleDivide(x, y);
		}catch (ArithmeticException ae) {
			System.out.println("----発生した例外----");
			System.out.println(ae);
		}
		System.out.println("x - y: " + (x - y));
	}

	double doubleDivide(double x,double y) {
		if(y == 0.0) {
			throw new ArithmeticException("数字は0では割れません。");
		}else {
			return x / y;
		}
	}

}
