package yamamoto;

import java.util.Scanner;


public class Kadai01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = 0;
		// 入力部
		while(true) {
			System.out.println("整数（1～65535）を入力してください。");
			String input = scn.nextLine();
			if(input.matches("([0-9])+")) { // 入力が数字のみで構成されているか
				num = Integer.valueOf(input);
				if(1 <= num && num <= 65535) { // 範囲に入っているか
					break;
				}
			}
			System.out.println("不正な値です。");
		}
		scn.close();
		// 出力部
		System.out.println("10進数" + num  + "は２進数の" + baseNumber(num, 2) + "です。");
		System.out.println("10進数" + num  + "は16進数の" + baseNumber(num, 16) + "です。");
	}

	public static String baseNumber(int number,int base) {
		StringBuilder answer = new StringBuilder();
		while(0 < number) {
			int remainder = number % base;
			if(remainder < 10) {
				answer.append(remainder);
			}else {
				answer.append((char)(55 + remainder)); // 10以上を英語のA-Fに変換(ユニコードにおいてAが１０進数で65)
			}
			number /= base;
		}
		return answer.reverse().toString(); // 位が逆順のため正しい並びにする
	}

}
