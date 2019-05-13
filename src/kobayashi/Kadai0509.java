package kobayashi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0509 {

	public static void main(String[] args) {


		int num = 0;

		for (;;) {
			try {
				System.out.println("8桁を入力して下さい。");

				Scanner scn = new Scanner(System.in);
				System.out.print("8桁を入力 :");
				num = scn.nextInt();

				if(9999999 < num && 100000000 > num ) {
					break;
				} else {
					System.out.println("不正です");
				}
				scn.close();
			} catch (InputMismatchException ie) {
				System.out.println("不正です。");
			}
		}

		String numstr = Integer.toString(num);

		StringBuilder sb = new StringBuilder(numstr);
		int year = Integer.valueOf(sb.substring(0,4));




		if (num % 4 == 0) {
			if (num % 100 == 0) {
				if (num % 400 == 0) {
					System.out.println("うるう年です");
				}
			}else{
				System.out.println("うるう年ではありません");
			}
		}else{
			System.out.println("うるう年ではありません");
		}
	}
}
