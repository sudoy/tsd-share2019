package jp.co.tsd.training2019.fujinoki;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {
		int sowa = 0;
		int kaishi = 0;
		int syuryo = 0;

		for (;;) {

			Scanner scn = new Scanner(System.in);
			try {
				System.out.print("開始する数値を入力してください。--> ");
				kaishi = scn.nextInt();
				System.out.print("終了する数値を入寮力してください。--> ");
				syuryo = scn.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("整数値を入力してください。");
				scn.close();
				continue;
			}

			for (int i = kaishi; i <= syuryo; i++) {
				if (i % 2 == 0) {
					sowa = sowa + i;
				}
			}
			break;
		}
		System.out.println("計算結果が100を超えたため、処理を中断しました。");
		System.out.println("超える前の総和は" + sowa + "になります。");
	}

}
