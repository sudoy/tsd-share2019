package inada;

import java.time.LocalDate;
import java.time.Period;

public class Sample9_1 {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2016, 12, 31);
		System.out.println("date             : " + date);
		System.out.println("date.plusDays(1) : " + date.plusDays(1));

		System.out.println("date             : " + date);
		System.out.println("----------------------------");

		LocalDate now = LocalDate.now();
		System.out.println("今日の日付       : " + now);
		LocalDate tomorrow = now.plusDays(1);
		System.out.println("明日の日付       : " + tomorrow);

		Period p = now.until(tomorrow);

		System.out.println(p.getDays());
	}

}
