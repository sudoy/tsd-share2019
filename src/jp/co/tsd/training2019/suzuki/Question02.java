package jp.co.tsd.training2019.suzuki;

import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("開始する数値を入力してください。--> ");
		String s = sc.nextLine();
		try {

			System.out.print("終了する数値を入力してください。--> ");
			int  end = sc.nextInt();
			int start = Integer.parseInt(s);
			calcu(start, end);
		} catch (Exception e) {
			System.out.println("整数値を入力してください。");
		}


		sc.close();
	}

	public static void calcu(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end; i++) {
			if(100 < sum + i) {
				System.out.println("計算結果が100を超えたため、処理を中断しました。");
				System.out.println("超える前の総和は" + sum + "になります。");
				return;
			}else if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(start + "から" + end + "までの総和は" + sum + "になります。");
	}

}
