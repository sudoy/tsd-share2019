package kobayashi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0509_3 {

	public static void main(String[] args) {

		System.out.println("8桁を入力して下さい。");

		Scanner scn = new Scanner(System.in);

		int input = 0;
		final int R_START = 20190501;
		final int HEI_START = 19890108;
		final int SYO_START = 19261225;
		final int TAI_START = 19120730;
		final int MEI_START = 18681023;

		for (;;) {
			try {
				System.out.print("8桁を入力 :");
				input = scn.nextInt();

				String str = Integer.toString(input);

				if (str.length() == 8) {
				} else {
					System.out.println("不正です。");
				}
				StringBuilder stb = new StringBuilder(str);

				int month = Integer.valueOf(stb.substring(4, 6));
				int day = Integer.valueOf(stb.substring(6, 8));

				if((month == 4 && day == 31) || (month == 6 && day == 31)) {
					System.out.println("不正です");
					continue;
				}
				if((month == 9 && day == 31) || (month == 11 && day == 31)) {
					System.out.println("不正です");
				}else {
					break;
				}
			} catch (InputMismatchException ie) {
				System.out.println("不正です。");
			} catch (StringIndexOutOfBoundsException se) {
				System.out.println("不正です。");
			}

			scn.nextLine();
		}
		scn.close();

		//文字列にして年月日にそれぞれ分ける
		String numstr = Integer.toString(input);
		StringBuilder sb = new StringBuilder(numstr);

		int year = Integer.valueOf(sb.substring(0, 4));
		int month = Integer.valueOf(sb.substring(4, 6));
		int day = Integer.valueOf(sb.substring(6, 8));

		//西暦
		System.out.println(year + "年" + month + "月" + day + "日");

		//和暦
		if (input >= R_START) {//令和

			year = year - 2019 + 1;

			if (year == 1) {
				System.out.println("令和元年" + month + "月" + day + "日");
			} else {
				System.out.println("令和" + year + "年" + month + "月" + day + "日");
			}

		} else if (input >= HEI_START) {//平成

			if (input < R_START) {
				year = year - 1989 + 1;
				System.out.println("平成" + year + "年" + month + "月" + day + "日");

			}else{
				year = year - 1989 + 1;

				if (year == 1) {
					System.out.println("平成元年" + month + "月" + day + "日");
				} else {
					System.out.println("平成" + year + "年" + month + "月" + day + "日");
				}
			}

		} else if (input >= SYO_START) {//昭和

			if (input < HEI_START) {
				year = year - 1926 + 1;
				System.out.println("昭和" + year + "年" + month + "月" + day + "日");

			} else {
				year = year - 1926 + 1;

				if (year == 1) {
					System.out.println("昭和元年" + month + "月" + day + "日");
				} else {
					System.out.println("昭和" + year + "年" + month + "月" + day + "日");
				}
			}

		} else if (input >= TAI_START) {//大正

			if (input < SYO_START){
				year = year - 1912 + 1;
				System.out.println("大正" + year + "年" + month + "月" + day + "日");

			} else {
				year = year - 1912 + 1;

				if (year == 1) {
					System.out.println("大正元年" + month + "月" + day + "日");
				} else {
					System.out.println("大正" + year + "年" + month + "月" + day + "日");
				}
			}

		} else if (input >= MEI_START) {//明治

			if (input < TAI_START) {
				year = year - 1868 + 1;
				System.out.println("明治" + year + "年" + month + "月" + day + "日");

			} else {
				year = year - 1868 + 1;

				if (year == 1) {
					System.out.println("明治元年" + month + "月" + day + "日");
				} else {
					System.out.println("明治" + year + "年" + month + "月" + day + "日");
				}
			}

		} else {//明治以前は範囲外の表示
			System.out.println("未対応です。");
		}

		scn.close();
	}


		//うるう年の判定
		public static void leap(int year){
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
				System.out.println("うるう年ではない。");
			} else {
				System.out.println("うるう年です。");
			}
		} else {
			System.out.println("うるう年ではない。");
		}


	}

}
