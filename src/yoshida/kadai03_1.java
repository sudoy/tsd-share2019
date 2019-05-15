package yoshida;

import java.util.Scanner;

public class kadai03_1 {
	private static final int firstmeiji = 1868;
	private static final int beforemeiji = 1873;
	private static final int meiji = 1912;
	private static final int taisyou = 1926;
	private static final int syouwa = 1989;
	private static final int heisei = 2019;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String num ;
		String error = "不正な値が入力されました";
		int date = 0;
		int y = 0;
		int m = 0;
		int d = 0;

		for (;;) {
			try {
				System.out.println("8桁を入力してください。");
				num = scn.nextLine();
				date = Integer.parseInt(num);

				if (num.length() == 8) {  //8桁以外の入力を処理
					break;
				} else {
					System.out.println("不正です。");
				}
			} catch (NumberFormatException e1) {  //文字などの入力処理
				System.out.println("不正です。");
				continue;
			}
		}

		String year = num.substring(0, 4);
		String month = num.substring(4, 6);
		String day = num.substring(6, 8);
		y = Integer.parseInt(year);
		m = Integer.parseInt(month);
		d = Integer.parseInt(day);

		getYear(y,m,d);
		System.out.println(wareki(y));
		System.out.println(warekiYear(y, m, d));
		System.out.println(gannen(y,m,d));
	}

	public static void getYear(int y , int m , int d) {
		System.out.println(y + "年" + m + "月" + d + "日");
	}

	public static boolean leapYear(int y) {
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
			return true ;
		} else {
			return false ;
		}
	}

	public static String wareki(int y) {
		if(y < beforemeiji) {
			return "明治6年以前の元号は対応してません。" ;

		}else if(y < meiji) {
			return "明治" ;

		}else if(y < taisyou ) {
			return "大正" ;

		}else if(y < syouwa) {
			return "昭和" ;

		}else if(y < heisei){
			return "平成" ;

		}else {
			return "令和" ;
		}
	}

	public static String warekichange(int y , int m ,int d) {
		if(wareki(y).equals("明治")) {
			if(y == meiji && m <= 5 || (m == 6 && d <= 29) ) {
				return "明治" ;
			}else {
				return "大正" ;
			}
		}else if(wareki(y).equals("大正")) {
			if(y == taisyou && (m <= 11) || (m == 12 && d <= 24)){
				return "大正" ;
			}else {
				return "昭和" ;
			}
		}else if(wareki(y).equals("昭和")){
			if(y == syouwa && (m == 1 && d <= 7)) {
				return "昭和" ;
			}else {
				return "平成" ;
			}
		}else if(wareki(y).equals("平成")){
			if(y == heisei && (m <= 4 && d <= 30)) {
				return "平成" ;
			}else {
				return "令和" ;
			}
		}else{
			return "令和" ;
		}

	}

	public static int warekiYear(int y, int m ,int d) {
		if(warekichange(y,m,d).equals("明治")) {
			return (y - firstmeiji + 1);//元年が0年になることを避けるためにプラス1年

		}else if(warekichange(y,m,d).equals("大正")) {//同じく
			return (y - meiji + 1);

		}else if(warekichange(y,m,d).equals("昭和")) {//同じく
			return (y - taisyou + 1);

		}else if(warekichange(y,m,d).equals("平成")) {//同じく
			return (y - syouwa + 1);

		}else {//同じく
			return (y - heisei + 1);
		}
	}

	public static String gannen(int y, int m, int d) {
		if(warekiYear(y, m, d) == 1) {
			return "元年" ;
		}else {
			String nen = Integer.toString(warekiYear(y, m, d));
			return nen ;
		}
	}
}
