package kobayashi;

public class Sample7_1 {

	public static void main(String[] args) {
		int x = 15;
		int y = 0;
		try {
			System.out.println("x / y: " + x / y);
			System.out.println("x * y: " + x * y);
		}catch(ArithmeticException ae){
			System.out.println("発生した例外:" + ae);
		}finally{
			System.out.println("finallyブロック。必ず実行されます。");
		}
		System.out.println("x - y:"  + (x - y));

	}

}
