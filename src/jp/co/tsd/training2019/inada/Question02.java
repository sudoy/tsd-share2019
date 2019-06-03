package jp.co.tsd.training2019.inada;

import java.util.Scanner;

public class Question02 {

	int start;
	int end;
	int sum;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Question02 q = new Question02();

		for (;;) {

			System.out.print("開始する数値を入力してください。--> ");
			String inputS = scn.next();
			System.out.print("終了する数値を入力してください。--> ");
			String inputE = scn.next();

			try {
				q.start = Integer.parseInt(inputS);
				q.end = Integer.parseInt(inputE);
				break;
			} catch (NumberFormatException e) {
				System.out.println("整数値を入力してください。");
			}

		}
		q.keisan();
		scn.close();
	}

	public void keisan() {
		sum = 0;
		int i = start;

		for (; i <= end; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
			if (100 < sum) {
				System.out.println("計算結果が100を超えたため、処理を中断しました。");
				System.out.println("超える前の総和は" + (sum - i) + "になります。");
				break;
			}
		}

		if (sum < 100) {
			System.out.println(start + "から" + end + "までの総和は" + sum + "になります。");
		}
	}

}
