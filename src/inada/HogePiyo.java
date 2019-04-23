package inada;

import java.time.LocalDate;
import java.time.Period;

public class HogePiyo {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();

		LocalDate l1 = now.withDayOfMonth(1);

		LocalDate l2 = now.plusMonths(1).withDayOfMonth(1).minusDays(1);

		Period p = l1.until(l2);

		for(int i = 0; i <= p.getDays(); i++) {
			System.out.println(l1);
			l1 = l1.plusDays(1);

		}
	}

}
