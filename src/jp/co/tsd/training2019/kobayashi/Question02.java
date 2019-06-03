package jp.co.tsd.training2019.kobayashi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {

		for (;;) {
			try {
				Scanner scn = new Scanner(System.in);

				System.out.println("開始する数値を入力してください。");
				int start = scn.nextInt();
				System.out.println("終了する数値を入力してください。");
				int finish = scn.nextInt();



				int x = finish - start;
				int total = 0;

					for (int i = start; start <= finish; i += 2) {
						total = total + i;

					}




				scn.close();

			} catch (InputMismatchException e) {
				System.out.println("整数値を入力してください。");
			}

		}

	}

}
