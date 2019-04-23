package yoshida;
import java.util.function.Predicate;
public class Sample8_5 {

	public static void main(String[] args) {
		Predicate<String> pre = (String t) -> {
			return t.equals("Hello") ;
		};
//		predicate<String> pre = t -> t.equals("Hello");
//		省略系

		System.out.println(pre.test("Hello"));
		System.out.println(pre.test("1"));
	}
}
