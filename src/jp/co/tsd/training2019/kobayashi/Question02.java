package jp.co.tsd.training2019.kobayashi;

import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		try {
			System.out.print("開始する数値を入力してください。-->");
			String strs = scn.next();
			System.out.print("終了する数値を入力してください。-->");
			String strf = scn.next();

			scn.close();

			int start = Integer.parseInt(strs);
			int finish = Integer.parseInt(strf);

			int total = 0;

			for (int i = start; i <= finish; i++) {

				if (total + i > 100) {
					System.out.println("計算結果が100を超えたため、処理を中断しました");
					System.out.println("超える前の総和は" + total + "になります。");
					return;

				} else if (i % 2 == 0) {
					total += i;
				}
			}
			System.out.println(start + "から" + finish + "までの総和は" + total + "になります");

		} catch (NumberFormatException e) {
			System.out.println("整数値を入力してください。");
		}

	}

}
