package yamamoto;

import java.time.LocalDate;

public class Mondai0423_1 {

	public static void main(String[] args) {
		// 今月の一日から月末までを一覧表示するプログラミング
		LocalDate now = LocalDate.now();
		int end = now.withDayOfMonth(1).plusMonths(1).plusDays(-1).getDayOfMonth();
		LocalDate start = now.withDayOfMonth(1);
		for(int i = 0; i < end; i++) {
			System.out.println(start.plusDays(i));
		}

		System.out.println("     カレンダー " + now.getYear() + "年" + now.getMonth().getValue() + "月");
		System.out.println("  日  月  火  水  木  金  土");
		int first = now.getDayOfWeek().getValue();
		int week = start.getDayOfWeek().getValue();
		if(6 < week) {
			week = 0;
		}
		for(int i = 0; i < week; i++) {
			System.out.print("    ");
		}
		for(int i = 0; i < end; i++) {
			if(6 < week) {
				System.out.println();
				week = 0;
			}
			if(start.plusDays(i).getDayOfMonth()<10) {
				System.out.print("   ");
			}else {
				System.out.print("  ");
			}
			System.out.print(start.plusDays(i).getDayOfMonth());
			week++;
		}
	}
}
