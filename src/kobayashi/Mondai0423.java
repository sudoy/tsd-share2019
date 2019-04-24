package kobayashi;

import java.time.LocalDate;
import java.time.Period;

public class Mondai0423 {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();

		LocalDate d1 = now.withDayOfMonth(1);
		LocalDate d2 = now.plusMonths(1).withDayOfMonth(1).minusDays(1);

		Period p = d1.until(d2);

		System.out.println(p.getDays());

		for(int i = 0 ;  i <= p.getDays() ; i++){
			System.out.println(d1);
			d1 = d1.plusDays(1);
		}

	}

}
