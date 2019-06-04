package fujinoki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Kadai3 {
	public static void main(String[] args) throws IOException {

		File dir = new File(args[0]);
		//もしフォルダがないとき
		if (!dir.exists()) {
			System.out.println("指定したフォルダが見つかりません。");
		}

		//フィルタを作成する
		FilenameFilter filterA = new FilenameFilter() {
			@Override
			public boolean accept(File file, String str) {

				//指定文字列でフィルタする
				//indexOfは指定した文字列が見つからなかったら-1を返す
				if (str.indexOf("DATA_A_") != -1) {
					return true;
				} else {
					return false;
				}
			}
		};
		FilenameFilter filterB = new FilenameFilter() {
			@Override
			public boolean accept(File file, String str) {

				//指定文字列でフィルタする
				//indexOfは指定した文字列が見つからなかったら-1を返す
				if (str.indexOf("DATA_B_") != -1) {
					return true;
				} else {
					return false;

				}

			}
		};

		BufferedReader brA = null;
		BufferedWriter bwA = null;
		BufferedReader brB = null;
		BufferedWriter bwB = null;

		try {
			//ファイルの一覧を取得
			File[] listA = dir.listFiles(filterA);
			File[] listB = dir.listFiles(filterB);

			//空のDATA_A_TOTAL.csvをつくる
			File totalA = new File(dir.getPath() + "\\DATA_A_TOTAL.csv");
			totalA.createNewFile();
			if (totalA.createNewFile()) {
				System.out.println("Aファイルの作成に成功しました");
			} else {
				if (totalA.exists()) {
					System.out.println("Aフォルダが存在します");
				} else {
					System.out.println("Aフォルダが存在しません");
				}
			}


			//空のDATA_B_TOTAL.csvをつくる
			File totalB = new File(dir.getPath() + "\\DATA_B_TOTAL.csv");
			totalB.createNewFile();
			if (totalB.createNewFile()) {
				System.out.println("Bファイルの作成に成功しました");
			} else {
				if (totalB.exists()) {
					System.out.println("Bファイルが存在します");
				} else {
					System.out.println("Bファイルが存在しません");
				}
			}
			// ファイルの存在を確認する

			//DATA_A ストリーム開く
			bwA = new BufferedWriter(new FileWriter(totalA));
			for (File f : listA) {
				brA = new BufferedReader(new FileReader(f));
				//リストを読み込んでファイルに書き込む
				String line;
				while ((line = brA.readLine()) != null) {
					bwA.write(line);
					bwA.newLine();

				}
			}
			bwB = new BufferedWriter(new FileWriter(totalB));
			for (File f : listB) {
				brB = new BufferedReader(new FileReader(f));
				//リストを読み込んでファイルに書き込む
				String line;
				while ((line = brB.readLine()) != null) {
					bwB.write(line);
					bwB.newLine();
				}

			}
		} catch (IOException e) {
		} catch (NullPointerException e) {
		} finally {
			//ストリーム閉じる
			try {
				if (brA != null) {
					brA.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bwA != null) {
					bwA.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (brB != null) {
					brB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bwB != null) {
					bwB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

