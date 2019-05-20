package kobayashi;

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0509 {

	public static void main(String[] args) {

		System.out.println("8桁を入力して下さい。");

		Scanner scn = new Scanner(System.in);

		int a = 0;

		for (;;) {
			try {
				System.out.print("8桁を入力 :");
				a = scn.nextInt();

				String str = Integer.toString(a);

				if( str.length() == 8) {
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

		int year = Integer.valueOf(sb.substring(0,4));
		int month = Integer.valueOf(sb.substring(4,6));
		int day = Integer.valueOf(sb.substring(6,8));

		//西暦
		DateTimeFormatter ad = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		 LocalDate ld = LocalDate.of(year,month,day);
		 System.out.println(ld.format(ad));

		 //和暦
		 DateTimeFormatter jc = DateTimeFormatter.ofPattern("Gy年MM月dd日");
		 JapaneseDate jd= JapaneseDate.of(year,month,day);
		 System.out.println(jd.format(jc));

		 //うるう年の判定
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
					System.out.println("うるう年ではない。");
			}else{
				System.out.println("うるう年です。");
			}
		}else{
			System.out.println("うるう年ではない。");
		}
	}
}
