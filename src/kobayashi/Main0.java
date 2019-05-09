package kobayashi;

import java.util.Scanner;

public class Main0 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in); 
		
		System.out.println(" ");
		int a = scn.nextInt();

		System.out.println(" ");
		int b = scn.nextInt();
		
		int c = a * b;
		
		if( c % 2 == 0) {
			System.out.println("Even");
		}else if(c % 2 == 1 ){
			System.out.println("Odd");
		}
		scn.close();
	}

}
