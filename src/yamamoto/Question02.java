package yamamoto;

import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean canmiss = false;
		System.out.print("開始する数値を入力してください。--> ");
		int startnumber = 0;
		try {
			startnumber = Integer.valueOf(scn.nextLine());
		} catch (NumberFormatException e) {
			canmiss = true;
		}
		System.out.print("終了する数値を入力してください。--> ");
		int endnumber = 0;
		try {
			endnumber =Integer.valueOf(scn.nextLine());
		} catch (NumberFormatException e) {
			canmiss = true;
		}
		System.out.println();
		if (canmiss) {
			System.out.println("整数値を入力してください。");
		} else if (endnumber <= startnumber) {
			System.out.println(startnumber + "から" + endnumber + "までの総和は0になります。");
		} else {
			int sum = 0;
			for (int i = startnumber; i <= endnumber; i++) {
				if (i % 2 == 0) {
					if (100 < sum + i) {
						System.out.println("計算結果が100を超えたため、処理を中断しました。");
						System.out.println("超える前の総和は" + sum + "になります。");
						break;
					} else {
						sum += i;
					}
				}
				if (i == endnumber) {
					System.out.println(startnumber + "から" + endnumber + "までの総和は" + sum + "になります。");
				}
			}
		}
	}
}
