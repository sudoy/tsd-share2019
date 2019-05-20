package yamamoto;

import java.util.Scanner;

public class Kadai02_2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int year = 0;
		int month = 0;
		int dayOfMonth = 0;
		DateData date;
		// 入力部
		while (true) {
			System.out.println("8桁の日付を入力してください。");
			String input = scn.nextLine();
			if (input.matches("([0-9]){8}")) { // 入力が八桁の数字であるか判定
				year = Integer.valueOf(input.substring(0, 4));
				month = Integer.valueOf(input.substring(4, 6));
				dayOfMonth = Integer.valueOf(input.substring(6, 8));
				date = new DateData(year, month, dayOfMonth);
				try {
					date.safe();
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
		date.show();
	}
}

class DateData {
	private int year;
	private int month;
	private int dayOfMonth;
	private int datedata;
	private String wareki = "";
	private String uru = "";
	private String warekiYear = "";
	static final int MEIZI = 18680125;
	static final int TAISYO = 19120730;
	static final int SYOWA = 19261225;
	static final int HEISEI = 19890108;
	static final int REIWA = 20190501;

	public DateData() {
	}

	public DateData(int year, int month, int dayOfMonth) {
		this.year = year;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		this.datedata = 10000 * year + 100 * month + dayOfMonth;
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) { // うるう年の判定
			uru = "うるう年です。";
		} else {
			uru = "うるう年ではない。";
		}
		putWareki();
	}

	/** 日付の範囲判定 */
	public void safe() throws Exception {
		if (datedata < MEIZI) {
			throw new Exception();
		}
		if (1 <= month && month <= 12) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (0 < dayOfMonth && dayOfMonth <= 31) {
					return;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if (0 < dayOfMonth && dayOfMonth <= 30) {
					return;
				}
			case 2:
				if (uru.equals("うるう年です。")) {
					if (0 < dayOfMonth && dayOfMonth <= 29) {
						return;
					}
				} else {
					if (0 < dayOfMonth && dayOfMonth <= 28) {
						return;
					}
				}
			}
		}
		throw new Exception();
	}

	/** warekiに和暦を代入し、warekYearに和暦の年を代入する */
	public void putWareki() { //
		if (MEIZI <= datedata && datedata < TAISYO) {
			wareki = "明治";
			if (year == 1868) {
				warekiYear = "元";
			} else {
				warekiYear = String.valueOf(year - 1867);
			}
		} else if (TAISYO <= datedata && datedata < SYOWA) {
			wareki = "大正";
			if (year == 1912) {
				warekiYear = "元";
			} else {
				warekiYear = String.valueOf(year - 1911);
			}
		} else if (SYOWA <= datedata && datedata < HEISEI) {
			wareki = "昭和";
			if (year == 1926) {
				warekiYear = "元";
			} else {
				warekiYear = String.valueOf(year - 1925);
			}
		} else if (HEISEI <= datedata && datedata < REIWA) {
			wareki = "平成";
			if (year == 1989) {
				warekiYear = "元";
			} else {
				warekiYear = String.valueOf(year - 1988);
			}
		} else {
			wareki = "令和";
			if (year == 2019) {
				warekiYear = "元";
			} else {
				warekiYear = String.valueOf(year - 2018);
			}
		}
	}

	/** DateDataの出力 */
	public void show() {
		System.out.println(year + "年" + String.format("%02d", month) + "月" + String.format("%02d", dayOfMonth) + "日");
		System.out.println(wareki + warekiYear + "年" + String.format("%02d", month) + "月"
				+ String.format("%02d", dayOfMonth) + "日");
		System.out.println(uru);
	}

	@Override
	public String toString() {
		return wareki + " " + warekiYear + " " + year + " " + month + " " + dayOfMonth + " " + uru;
	}

}
