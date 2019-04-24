package fujinoki;

import java.time.LocalDate;

public class Mondai1 {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate firstdate = now.withDayOfMonth(1);
		LocalDate lastdate = now.plusMonths(1).withDayOfMonth(1).minusDays(1);
		
		for(int i = 0;i <= lastdate;i++);
		System.out.println(firstdate.plusDays(i));

	}

}
