package fujinoki;

import java.util.Scanner;

public class Rensyu_3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = 0;

		for (;;) {
			try {
				System.out.println("8桁を入力してください。");
				String s = scn.next();
				num = Integer.parseInt(s);

				int year = Integer.valueOf(s.substring(0, 4));
				int month = Integer.valueOf(s.substring(4, 6));
				int day = Integer.valueOf(s.substring(6));

				if (10000000 <= num && num <= 99999999) {
					if ((month == 4 || month == 6 || month == 9 || month == 11) && 1 <= day && day <= 30) {
						break;
					} else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) && 1 <= day && day <= 31) {
						break;
					} else if (year % 4 == 0) {
						if (year % 100 == 0 && year % 400 == 0) {
							if (month == 2 && 1 <= day && day <= 29) {
								break;
							}
						}
					} else if (month == 2 && 1 <= day && day <= 28) {
						break;
					}
				}

			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.out.println("不正です。");
				continue;
			}
			System.out.println("不正です");
		}

		String s = String.valueOf(num);
		int year = Integer.valueOf(s.substring(0, 4));
		int month = Integer.valueOf(s.substring(4, 6));
		int day = Integer.valueOf(s.substring(6));

		System.out.println(year + "年" + month + "月" + day + "日");

		int meiji = year - 1867;
		int taisho = year - 1911;
		int showa = year - 1925;
		int heisei = year - 1988;
		int reiwa = year - 2018;

		if (meiji == 1) {
			System.out.println("明治元年" + month + "月" + day + "日");
		} else if (18680125 <= num && num <= 19120729) {
			System.out.println("明治" + meiji + "年" + month + "月" + day + "日");

		} else if (taisho == 1) {
			System.out.println("大正元年" + month + "月" + day + "日");
		} else if (19120730 <= num && num <= 19261224) {
			System.out.println("大正" + taisho + "年" + month + "月" + day + "日");

		} else if (showa == 1) {
			System.out.println("昭和元年" + month + "月" + day + "日");
		} else if (19261225 <= num && num <= 19890107) {
			System.out.println("昭和" + showa + "年" + month + "月" + day + "日");

		} else if (heisei == 1) {
			System.out.println("平成元年" + month + "月" + day + "日");
		} else if (19890108 <= num && num <= 20190430) {
			System.out.println("平成" + heisei + "年" + month + "月" + day + "日");

		} else if (reiwa == 1) {
			System.out.println("令和元年" + heisei + "年" + month + "月" + day + "日");
		} else if (20190501 <= num) {
			System.out.println("令和" + reiwa + "年" + month + "月" + day + "日");
		}
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
				System.out.println("うるう年ではない。");
			} else {
				System.out.println("うるう年");
			}
		} else {
			System.out.println("うるう年ではない。");
		}
		scn.close();
	
	}

}
