package suzuki;

import java.time.LocalDate;

public class Rensyu0423 {

	public static void main(String[] args) {


		LocalDate now = LocalDate.now();
		LocalDate start = now.withDayOfMonth(1);
		LocalDate goal = now.plusMonths(1).withDayOfMonth(1).minusDays(1);

		for(int i = 0; ; i++) {
			System.out.println(start.plusDays(i));
			if(start.plusDays(i).equals(goal)) {
				break;
			}
		}

	}

}
