package yoshida;
import java.time.LocalDate ;
import java.time.Period;
public class Sample9_1 {

	public static void main(String[] args) {

		//LocalDateクラスはnewを利用して直接インスタンス化できない
		//LocalDate date = new LocalDate(2016, 12, 31);コンパイルエラー

		//LocalDate.ofメソッドを利用して指定した日付を保持するインスタンスを取得
		LocalDate date = LocalDate.of(2016, 12, 31);

		System.out.println("date               :" + date);
		System.out.println("date.plusDays(1)   :" + date.plusDays(1));

		//plusDaysメソッドを使用してもdateのインスタンスが表す日付は変わらない
		System.out.println("date               :" + date);

		System.out.println("-----------------------------");
		//nowメソッドを使用しても今日の日付を保持したインスタンスを取得
		LocalDate now = LocalDate.now();
		System.out.println("今日の日付         :" + now);
		LocalDate tomorrow = now.plusDays(1);
		System.out.println("明日の日付         :" + tomorrow);

		//Periodを使用して対象の日付までの日数を取得
		Period p = now.until(tomorrow);

		//System.out.println(p); P1Dと表示される
		System.out.println(p.getDays());
	}

}
