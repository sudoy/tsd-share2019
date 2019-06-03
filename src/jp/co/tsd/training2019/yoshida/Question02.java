package jp.co.tsd.training2019.yoshida;

import java.util.Scanner;

public class Question02 {
	public static String x  = null;
	public static String y  = null;
	public static int start = 0;
	public static int end = 0 ;
	public static int sum = 0 ;


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Question02 q = new Question02();
		try {
			System.out.print("開始する数値を入力してください-->_");
			x = scn.nextLine();
			System.out.print("終了する数値を入力してください-->_");
			y = scn.nextLine();
			start = Integer.parseInt(x);
			end = Integer.parseInt(y);
		}catch(NumberFormatException e) {
			System.out.println("整数値を入力してください。");
		}
		q.keisan();

	}

	public void keisan() {
		for(int i = start ; i <= end ; i++) {
			if(i % 2 == 0) {
				sum += i ;
			}else if(100 <= sum) {
				System.out.println("計算結果が100を超えたため、処理を中断しました。");
				System.out.println("超える前の総和は" + (sum - i) + "になります。");
				break ;
			}
		}if(sum < 100 && 1 < start) {
			System.out.println(start + "から" + end + "までの総和は" + sum + "になります。");
		}
	}

}
