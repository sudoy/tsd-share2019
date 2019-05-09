package yamamoto;

import java.util.Scanner;

public class Question01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("テストの点数を入力してください。");
		boolean canmiss= false;
		String[] subject = { "国語", "算数", "理科", "社会" };
		int[] score = new int[subject.length];
		for (int i = 0; i < subject.length; i++) {
			System.out.print("  " + subject[i] + " --> ");
			try {
				score[i] = Integer.valueOf(scn.nextLine());
				if(score[i]<0||100<score[i]) {
					canmiss = true;
				}
			} catch (NumberFormatException e) {
				canmiss = true;
			}

		}
		System.out.println();
		if(canmiss) {
			System.out.println("点数には0から100までの整数値を入力してください。");
		}else {
			int sum=0;
			for(int i = 0; i < subject.length; i++) {
				sum += score[i];
			}
			double avg = 1.0 * sum / subject.length;
			System.out.println("合計点は " + sum + "、平均点は "+ avg + "  です。");
		}

	}

}
