package jp.co.tsd.training2019.yamamoto;

import java.util.Scanner;

public class Question02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String inputbeginNum = "";
		int beginNum;
		String inputendNum = "";
		int endNum;
		int ans = 0;
		while(true) {
			System.out.print("開始する数値を入力してください。--> ");
			inputbeginNum = scn.nextLine();
			System.out.print("終了する数値を入力してください。--> ");
			inputendNum = scn.nextLine();
			System.out.println();
			try {
				beginNum = Integer.valueOf(inputbeginNum);
				endNum = Integer.valueOf(inputendNum);
			} catch (Exception e) {
				System.out.println("整数値を入力してください。");
				return;
			}
			break;
		}
		for(int i = beginNum;i<=endNum;i++) {
			if(100<ans+i) {
				System.out.println("計算結果が100を超えたため、処理を中断しました。");
				System.out.println("超える前の総和は" + ans + "になります。");
				return;
			}
			if(i%2==0) {
				ans += i;
			}
		}
		System.out.println(beginNum + "から" + endNum + "までの総和は" + ans + "になります。");
	}

}
