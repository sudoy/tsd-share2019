package yamamoto;

import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Kadai02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int year = 0;
		int month = 0;
		int dayOfMonth = 0;
		JapaneseDate date;
		// 入力部
		while (true) {
			System.out.println("8桁の日付を入力してください。");
			String input = scn.nextLine();
			if (input.matches("([0-9]){8}")) { // 入力が数字のみで構成されているか
				year = Integer.valueOf(input.substring(0, 4));
				month = Integer.valueOf(input.substring(4, 6));
				dayOfMonth = Integer.valueOf(input.substring(6, 8));
				try {
					date = JapaneseDate.of(year, month, dayOfMonth);
					if (date.until(JapaneseDate.now()).isNegative()) {
						System.out.println("未来は入力できません。");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println("日付の範囲外です。");
					continue;
				}
			}
			System.out.println("不正な値です。");
		}
		scn.close();
		// 出力部
		showSeireki(date);
		showWareki(date);
		showUru(year);
	}

	public static void showSeireki(JapaneseDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu年MM月dd日");
		System.out.println(formatter.format(date));
	}

	public static void showWareki(JapaneseDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Gyy年MM月dd日");
		System.out.println(formatter.format(date));
	}

	public static void showUru(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println("うるう年です。");
		} else {
			System.out.println("うるう年ではない。");
		}
	}
}
