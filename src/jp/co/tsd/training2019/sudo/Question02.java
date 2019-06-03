package jp.co.tsd.training2019.sudo;

import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int start = 0;
		int end = 0;
		try {
			System.out.print("開始する数値を入力してください。--> ");
			String str1 = scn.next();
			System.out.print("終了する数値を入力してください。--> ");
			String str2 = scn.next();
			System.out.println();

			start = Integer.parseInt(str1);
			end = Integer.parseInt(str2);

		}catch(NumberFormatException e) {
			System.out.println("整数値を入力してください。");
			return;

		} finally {
			scn.close();
		}

		// 総和
		boolean isOver = false;
		int sum = 0;
		for(int i = start; i <= end; i++) {
			if(sum + i > 100) {
				isOver = true;
				break;
			}

			if(i % 2 == 0) {
				sum += i;
			}
		}

		if(isOver) {
			System.out.println("計算結果が100を超えたため、処理を中断しました。");
			System.out.println("超える前の総和は" + sum + "になります。");
		}else {
			System.out.println(start + "から" + end + "までの総和は" + sum + "になります。");
		}
	}

}
