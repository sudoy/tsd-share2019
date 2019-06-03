package yoshida;

import java.util.Scanner;

public class Kadai01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long value = 0;

		for( ; ; ) {
			try {
				System.out.println(">整数（1～65535）を入力してください。");
				System.out.print(">");
				String str = scn.nextLine();
				value = Long.parseLong(str);
			}catch(NumberFormatException e) {
				System.out.println("不正な値です。");
				continue ;
			}
			if(0 < value && value <= 65535) {
				break;
			}else {
				System.out.println("不正な値です。");
			}

			scn.close();
		}

		division(value,2);
		division(value,16);
	}

	public static void division(long value , int divide) {
		StringBuilder answer = new StringBuilder();
		long num = value;

		while(!(value == 0)) {
			int v = (int) value;
			int keisan = v % divide;
			switch(keisan) {
			case 10:
				String a = "A";
				answer.append(a);
				break;
			case 11:
				String b = "B" ;
				answer.append(b);
				break;
			case 12:
				String c = "C"  ;
				answer.append(c);
				break;
			case 13:
				String d = "D" ;
				answer.append(d);
				break;
			case 14:
				String e = "E" ;
				answer.append(e);
				break;
			case 15:
				String f = "F" ;
				answer.append(f);
				break;
			default:
				answer.append(keisan);
			}
			value = value / divide;
		}
		answer.reverse();
		System.out.println(">10進数" + num +"は" + divide + "進数の"+ answer +"です。");
	}
}
