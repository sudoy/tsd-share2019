package inada;

import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.print("開始する数値を入力してください。--> ");
		String str1 = scn.nextLine();
		System.out.print("終了する数値を入力してください。--> ");
		String str2 = scn.nextLine();
		System.out.println();

		int i1 = 0;
		int i2 = 0;
		int sum = 0;

		try {
			i1 = Integer.parseInt(str1);
			i2 = Integer.parseInt(str2);
		}catch(NumberFormatException e) {
			System.out.println("整数値を入力してください。");
			System.exit(0);
		}

		for(int j = i1; j <= i2; j++) {
			if(j % 2 == 0) {

				sum += j;
			}else {

			}
			if(sum > 100) {
				System.out.println("計算結果が100を超えたため、処理を中断しました。");
				System.out.println("超える前の総和は" + (sum - j) + "になります。");
				System.exit(0);
			}
		}
		System.out.println(i1 + "から" + i2 + "までの総和は" + sum + "になります。");

		scn.close();
	}

}
