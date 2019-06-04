package fujinoki;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Rensyu_2 {
	public static void main(String[] args) throws ParseException {
		Scanner scn = new Scanner(System.in);
		int num = 0;

		for (;;) {
			try {
				System.out.println("8桁を入力してください。");
				String a = scn.next();
				num = Integer.parseInt(a);

				if (10000000 <= num && num < 100000000) {
					break;
				} else {
					System.out.println("不正です。");
				}
			} catch (NumberFormatException e) {
				System.out.println("不正です。");
				continue;

			}

		}
		String text = Integer.toString(num);
		LocalDate ld = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyyMMdd"));

		System.out.println(ld);
		//西暦
		System.out.println(ld.getYear() + "年" + ld.getMonthValue() + "月" + ld.getDayOfMonth() + "日");

		//和暦
		JapaneseDate jpDate = JapaneseDate.of(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
		DateTimeFormatter f = DateTimeFormatter.ofPattern("Gy年M月d日");
		f.withChronology(JapaneseChronology.INSTANCE);
		System.out.println(f.format(jpDate));

		if (ld.isLeapYear()) {
			System.out.println("うるう年です。");
		} else {
			System.out.println("うるう年ではない。");
		}

	}

}
