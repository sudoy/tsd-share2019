package fujinoki;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);//準備

		int s1 = scn.nextInt();//入力値を読み込み
		
		
		if(s1 == 111) {
			System.out.println(3);
		}else if(s1 == 011) {
			System.out.println(2);
		}else if(s1 == 101) {
			System.out.println(2);
		}else if(s1 == 110) {
			System.out.println(2);
		}else if(s1 == 100) {
			System.out.println(1);
		}else if(s1 ==010) {
			System.out.println(1);
		}else if(s1 == 001) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		scn.close();	
	}

}
