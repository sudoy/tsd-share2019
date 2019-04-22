package sudo;

public class Sample7_1 {

	public static void main(String[] args) {
		int x = 15;
		int y = 0;
		try {
			System.out.println("x / y: " + x / y); // ArithmeticException
			System.out.println("2 * y: " + x * y);
		} catch (NullPointerException e) {

		} catch (ArithmeticException e) {
			System.out.println("発生した例外: " + e);

		} catch (RuntimeException e) {

		} finally {
			System.exit(0); // プログラム終了
			System.out.println("finallyブロック。必ず実行されます。");
		}
		System.out.println("x - y: " + (x - y));

	}

}

// 例外処理を書いていないとき
// 例外が発生した場合（ArithmeticException)
// 例外が発生した場合（他の例外)
// 発生しない場合
// e.printStackTrace()