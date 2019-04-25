package yamamoto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Typinggame {

	public static void main(String[] args) {

		// 準備

		Scanner scn = new Scanner(System.in);
		Random rnd = new Random();
		long t0; // 処理開始前の時間を保持する
		long time; // 実行時間を保持する
		List<String> txt = new ArrayList<String>();
		File addres = new File("\\\\192.168.3.62\\public\\研修資料\\data.txt");
		BufferedReader in = null;
		int mozi = 0;
		try {
			in = new BufferedReader(new FileReader(addres));
			String rec;
			char c;
			StringBuilder st = new StringBuilder();
			while ((rec = in.readLine()) != null) { // 改行まで読み取り
				for (int i = 0; i < rec.length(); i++) {
					c = rec.charAt(i); // 1文字ずつ分割
					if (c == ',') { // ','で文章の分割
						txt.add(st.toString());
						st = new StringBuilder();
					} else {
						st.append(c);
					}
				}
				txt.add(st.toString());
				st = new StringBuilder();
			}
			//			for (String x : txt) {
			//				System.out.println(x);  // 入力確認
			//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0); // 強制終了
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// メイン処理
		System.out.print("何かキーを入力してください：");
		scn.nextLine();
		t0 = System.currentTimeMillis();
		for (int i = 1; i < 6; i++) {
			int x = rnd.nextInt(txt.size() / 2);
			System.out.println();
			System.out.println("**************** 第" + i + "問 ****************");
			System.out.println(txt.get(x * 2));
			System.out.println(txt.get(x * 2 + 1));
			mozi += txt.get(x * 2 + 1).length();
			while (true) {
				System.out.println();
				System.out.println("【入力してください】");
				String enter = scn.nextLine();
				if (enter.equals(txt.get(x * 2 + 1))) {
					break;
				}
			}
			txt.remove(x * 2);
			txt.remove(x * 2);

		}

		// 結果表示

		time = (System.currentTimeMillis() - t0) / 1000;
		double t = mozi / time;
		BigDecimal bi = new BigDecimal(String.valueOf(t));
		System.out.println("**************************************");
		System.out.println("終了しました。おつかれさまでした。");
		System.out.println();
		System.out.println("**************** 成績 ****************");
		System.out.println("  時間      ：" + time + " 秒");
		System.out.println("  文字数    ：" + mozi + " 文字");
		System.out.println("  １秒当たり：" + bi.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue() + "文字");
		System.out.println("**************************************");

		scn.close();
	}

}
