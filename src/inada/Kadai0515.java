package inada;

import java.util.Scanner;

public class Kadai0515 {

	private static int year;
	private static int month;
	private static int day;

	//変わったら困る値は定数化
	private static final int LAST_DAY = 31;
	private static final int FIRST_DAY = 1;
	private static final int MEIJI6 = 18730101;
	private static final int TAISYO_START = 19120730;
	private static final int SYOWA_START = 19261225;
	private static final int HEISEI_START = 19890108;
	private static final int REIWA_START = 20190501;

	private static String input;
	private static StringBuilder nengappi;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		nengappi = new StringBuilder();

		for (;;) {

			System.out.println("8桁を入力してください。");
			input = scn.next();

			if (input.length() != 8) {
				System.out.println("不正です。1");
				continue;
			}

			try {
				year = Integer.parseInt(input.substring(0, 4));
				month = Integer.parseInt(input.substring(4, 6));
				day = Integer.parseInt(input.substring(6, 8));
			} catch (NumberFormatException e) {
				System.out.println("不正です。2");
				continue;
			}

			//うるう年じゃないのに2月28日より大きい日付を入れた場合↓
			if ((month == 2) && (FIRST_DAY <= day) && (day <= LAST_DAY - 2) && (year % 4 != 0)) {//()つける
				System.out.println("不正です。3");
				continue;

			} else if ((month == 2) && (FIRST_DAY <= day) && (day <= LAST_DAY - 2) && (year % 4 == 0)) {
				if ((year % 100 == 0) && (year % 400 != 0)) {
					System.out.println("不正です。4");
					continue;
				} else {
					break;
				}
			} else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
				if ((FIRST_DAY <= day) && (day <= LAST_DAY - 1)) {
					break;
				} else {
					System.out.println("不正です。5");
					continue;
				}
			} else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)
					|| (month == 12)) {
				if ((FIRST_DAY <= day) && (day <= LAST_DAY)) {
					break;
				} else {
					System.out.println("不正です。6");
					continue;
				}

			} else {
				System.out.println("不正です。7");
				continue;
			}

		}
		//年月日に変換
		nengappi.append(input.substring(0, 4)).append(input.substring(4, 6)).append(input.substring(6, 8))
				.insert(4, "年").insert(7, "月").append("日");
		System.out.println(nengappi);

		int inputInt = Integer.parseInt(input);
		wareki(inputInt);//和暦変換総合メソッド呼び出し

		uruu(year);//うるう年判定メソッド呼び出し

		scn.close();
	}

	public static void wareki(int inputInt2) {//和暦変換総合

		int rGan = gan(REIWA_START);
		int hGan = gan(HEISEI_START);
		int sGan = gan(SYOWA_START);
		int tGan = gan(TAISYO_START);
		int m6 = gan(MEIJI6);

		if (REIWA_START <= inputInt2) {
			warekihenkan(rGan, "令和");
		} else if (HEISEI_START <= inputInt2 && inputInt2 < REIWA_START) {
			warekihenkan(hGan, "平成");
		} else if (SYOWA_START <= inputInt2 && inputInt2 < HEISEI_START) {
			warekihenkan(sGan, "昭和");
		} else if (TAISYO_START <= inputInt2 && inputInt2 < SYOWA_START) {
			warekihenkan(tGan, "大正");
		} else if (MEIJI6 <= inputInt2 && inputInt2 < TAISYO_START) {
			warekihenkan(m6, "明治");
		} else {
			System.out.println("日本でのグレゴリオ暦の採用は明治6年1月1日以降です。");
			System.exit(0);
		}

		System.out.println(nengappi);
	}

	public static void uruu(int year2) { //うるう年判定

		if (year2 % 4 == 0) {
			if ((year2 % 100 == 0) && (year2 % 400 != 0)) {
				System.out.println("うるう年ではない。");
			} else {
				System.out.println("うるう年です。");
			}
		} else {
			System.out.println("うるう年ではない。");
		}

	}

	public static int gan(int g) {//変換、切取、変換  (各元号の元年を抽出)
		return Integer.parseInt(String.valueOf(g).substring(0, 4));
	}

	public static void warekihenkan(int gannen, String gengo) {//和暦変換
		int wareki = Integer.parseInt(input.substring(0, 4)) - (gannen - 1);
		nengappi.replace(0, 4, gengo + wareki);
		ichi(nengappi);
	}

	public static StringBuilder ichi(StringBuilder nengappi2) {//1年を元年に変換
		if (nengappi2.substring(2, 4).equals("1年")) {
			return nengappi2.replace(2, 3, "元");
		} else {
			return nengappi2;
		}
	}

}
