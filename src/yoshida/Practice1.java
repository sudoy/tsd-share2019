package yoshida;
import java.time.LocalDate;
import java.time.Period;
public class Practice1 {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		LocalDate first = now.withDayOfMonth(1);
		LocalDate plusmonth = first.plusMonths(1);
		LocalDate finish = plusmonth.minusDays(1);
		Period p = first.until(finish);

		for(int x = 0 ; x <= p.getDays() ; x++) {
			LocalDate a = first.plusDays(x);
			System.out.println(a);
		}
	}
}
