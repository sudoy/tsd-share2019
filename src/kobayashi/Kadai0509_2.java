package kobayashi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0509_2 {
	public static void main(String[] args) {

		System.out.println("8桁を入力して下さい。");

		Scanner scn = new Scanner(System.in);

		int a = 0;

		for (;;) {
			try {
				System.out.print("8桁を入力 :");
				a = scn.nextInt();

				String str = Integer.toString(a);

				if (str.length() == 8) {
					break;
				} else {
					System.out.println("不正です。");
				}
			} catch (InputMismatchException ie) {
				System.out.println("不正です。");
			}
			scn.nextLine();
		}
		scn.close();

		//文字列にして年月日にそれぞれ分ける
		String numstr = Integer.toString(a);
		StringBuilder sb = new StringBuilder(numstr);

		int year = Integer.valueOf(sb.substring(0, 4));
		int month = Integer.valueOf(sb.substring(4, 6));
		int day = Integer.valueOf(sb.substring(6, 8));

		//西暦
		System.out.println(year + "年" + month + "月" + day + "日");

		//和暦
		if (year >= 2019) {//令和
			year = year - 2019 + 1;
			if (year == 1) {
				System.out.println("令和元年" + month + "月" + day + "日");
			} else {
				System.out.println("令和" + year + "年" + month + "月" + day + "日");
			}

		} else if (year >= 1989) {//平成
			year = year - 1989 + 1;
			if (year == 1) {
				System.out.println("平成元年" + month + "月" + day + "日");
			} else {
				System.out.println("平成" + year + "年" + month + "月" + day + "日");
			}

		} else if (year >= 1926) {//昭和
			year = year - 1926 + 1;
			if (year == 1) {
				System.out.println("昭和元年" + month + "月" + day + "日");
			} else {
				System.out.println("昭和" + year + "年" + month + "月" + day + "日");
			}

		} else if (year >= 1912) {//大正
			year = year - 1926 + 1;
			if (year == 1) {
				System.out.println("大正元年" + month + "月" + day + "日");
			} else {
				System.out.println("大正" + year + "年" + month + "月" + day + "日");
			}

		} else if (year >= 1868) {//明治
			year = year - 1868 + 1;
			if (year == 1) {
				System.out.println("明治元年" + month + "月" + day + "日");
			} else {
				System.out.println("明治" + year + "年" + month + "月" + day + "日");
			}

		} else {//明治以前は範囲外の表示
			System.out.println("その年は未対応です。");
		}

		//うるう年の判定
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
