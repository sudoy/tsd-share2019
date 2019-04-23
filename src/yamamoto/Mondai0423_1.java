package yamamoto;

import java.time.LocalDate;

public class Mondai0423_1 {

	public static void main(String[] args) {
		// 今月の一日から月末までを一覧表示するプログラミング
		LocalDate now = LocalDate.now();
		int end = now.withDayOfMonth(1).plusMonths(1).plusDays(-1).getDayOfMonth();
		now = LocalDate.now();
		now = now.withDayOfMonth(1);
		for(int i = 0; i < end; i++) {
			System.out.println(now.plusDays(i));
		}
	}
}
