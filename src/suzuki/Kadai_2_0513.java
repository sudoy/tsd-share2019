package suzuki;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kadai_2_0513 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int input;
		do {
			try {
				System.out.println("8桁を入力してください。");
				input = scn.nextInt();
				if(9999999 < input && input < 100000000) { //8桁ならループ終わり
					break;
				}else {
					System.out.println("不正な値です。");
				}
			}catch(InputMismatchException e) {
				System.out.println("不正な値です。");
				scn.next();
			}
		}while(true);

		try {
			DatePrint2 date = new DatePrint2(input);
			date.printAd();
			date.printJc(input);
			System.out.println(date.judge());
		} catch (Exception e) {
			System.out.println("日付に変換できません。");
			System.out.println(e.getMessage());
		}
		scn.close();
	}

}
class DatePrint2{

	private int year;
	private int month;
	private int day;

	public static final int meiji6 = 18730101; //（新暦）明治は1873年1月1日から明治45年1912年7月29日まで
	public static final int taisyoF = 19120730; //大正は1912年7月30日から大正15年1926年12月24日まで
	public static final int syowaF = 19261225; //昭和は1926年12月25日から昭和64年1989年1月7日まで
	public static final int heiseiF = 19890108; //平成は1989年1月8日から平成31年2019年4月30日まで
	public static final int reiwaF = 20190501; //令和は2019年5月1日から

	public DatePrint2(int input) throws Exception {
		String inputS = String.valueOf(input);
		year =  Integer.valueOf(inputS.substring(0, 4));
		month = Integer.valueOf(inputS.substring(4, 6));
		day = Integer.valueOf(inputS.substring(6));
		monthCheck();
		dayCheck();
	}

	public void printAd() { //西暦表示
		System.out.println(year + "年" + month + "月" + day + "日");
	}

	public void printJc(int input) throws Exception { //和暦表示
		System.out.println(japaneseCalendar(input) + "年" + month + "月" + day + "日");
	}

	public String judge() { //うるう年かどうか

		String uru = "うるう年です。";
		if(year % 4 == 0) {
			if(year % 100 == 0 && year % 400 != 0) {
				uru = "うるう年ではない。";
			}
		}else {
			uru = "うるう年ではない。";
		}
		return uru;
	}

	public void monthCheck() throws Exception {

		if(month < 1 || 12 < month) { //月の制限
			throw new Exception("月は1～12までです。");
		}
	}

	public void dayCheck() throws Exception {

		Pattern p = Pattern.compile("4|6|9|11");
        Matcher m = p.matcher(String.valueOf(month));
        if(m.find()) { //4,6.9.11月のとき
        	if(day < 1 || 30 < day) { //1～30日じゃなかったら
        		throw new Exception("日数が不正です。");
        	}
        }else if(month == 2) { //2月のとき
        	int lastDay = judge().equals("うるう年です。") ? 29 : 28;
        	if(day < 1 || lastDay < day) {
        		throw new Exception("日数が不正です。");
        	}
        }else { //1,3,5,7,8,10,12月のとき
        	if(day < 1 || 31 < day) { //1～31日じゃなかったら
        		throw new Exception("日数が不正です。");
        	}
        }
	}

	public String japaneseCalendar (int input) throws Exception { //西暦を和暦に

		String jc;
		if(reiwaF <= input) {
			jc = year == 2019 ? "令和元" : "令和" + String.valueOf(year - 2018);
		}else if(heiseiF <= input) {
			jc = year == 1989 ? "平成元" : "平成" + String.valueOf(year - 1988);
		}else if(syowaF <= input) {
			jc = year == 1926 ? "昭和元" : "昭和" + String.valueOf(year - 1925);
		}else if(taisyoF <= input) {
			jc = year == 1912 ? "大正元" : "大正" + String.valueOf(year - 1911);
		}else if(meiji6 <= input) {
			jc = "明治" + String.valueOf(year - 1867);
		}else {
			throw new Exception("明治6年から和暦で表示できます。");
		}
		return jc;
	}
}