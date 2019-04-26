package suzuki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Typing {

	public static void main(String[] args) {

		File data = new File("C:\\java\\data.txt");
		List<String> dataList = new ArrayList<String>();

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(data));

			String line;
			while((line = in.readLine()) != null) {
				dataList.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Scanner scn = new Scanner(System.in);
		List<String> con = new ArrayList<>();
		String que;
		String ans;
		int sum = 0;

		System.out.print("タイピングゲームを開始します。\n何かキーを入力してください：");
		String s = scn.nextLine();
		LocalTime start = LocalTime.now();

		for(int i = 0; i < 3;) {
			que = randomS(dataList);
			if(!con.contains(que)) {
				System.out.println("\n**************** 第" + (i + 1) + "問 ****************");
				System.out.println(que + "\n"); //問題表示
				s = que.substring(que.indexOf("\n") + 1);
				do{
					System.out.println("【入力してください】");
					ans = scn.nextLine(); //答え
					sum += ans.length();
				}while(!ans.equals(s));

				con.add(que);
				i++;
			}
		}

		LocalTime end = LocalTime.now();
		System.out.println("\n**************************************");
		System.out.println("終了しました。おつかれさまでした。");
		System.out.println("\n**************** 成績 ****************");
		Duration total = Duration.between(start, end);
		System.out.println("時間　　　：" + total.getSeconds() + " 秒");
		System.out.println("文字数　　：" + sum + "文字");
		double d1 = total.getSeconds();
		double d2 = (sum / d1) * 10;
		d2 = Math.round(d2);
		System.out.println("１秒当たり：" + d2 / 10 + "文字");
		System.out.println("**************************************");

		scn.close();


	}

	public static String randomS(List<String> list) { //問題取り出し
		while(true) {
			int r = (int)(Math.random() * 100);
			if(r < list.size()) {
				return list.get(r).replace(',', '\n');
			}
		}
	}
}
