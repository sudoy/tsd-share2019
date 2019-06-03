package yamamoto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Kadai03 {
	public boolean checkPath(String[] path) {
		if (path == null || path.length == 0) { // 実行時引数が存在するか
			System.out.println("実行時引数にパスを入力してください。");
			return false;
		}
		File input = new File(path[0]);
		if (input.exists() == false) { // 入力されたフォルダが存在しているか
			System.out.println("実行時引数に正しいパスを入力してください。");
			return false; // 終了
		}
		return true;
	}

	/**
	 * File配列のファイルを順次読み込み、１つのファイルに出力します。
	 * @param list ファイルのパスまで保持した
	 * @param filename 使用するファイルセットの名前
	 */
	public void copyData(File[] list, String filename) {
		System.out.println(filename + "をまとめます。");
		if (list.length == 0) {
			System.out.println("ファイルが存在しません。");
			return;
		}
		BufferedReader in = null;
		BufferedWriter out = null;
		File outAddress = new File(list[0].getPath().replaceAll("([0-9]{8})\\.csv$", "TOTAL.csv")); // 書き込み先パスの作成
		try {
			out = new BufferedWriter(new FileWriter(outAddress)); // 書き込み先の指定
			for (File address : list) {
				in = new BufferedReader(new FileReader(address)); // 読み込み先の指定
				String line;
				while ((line = in.readLine()) != null) {
					out.write(line);
					out.newLine();
				}
				try {
					if (in != null) {
						in.close(); //読み込み先を閉じる
					}
				} catch (IOException e) {
					System.out.println("ファイルを閉じられません。");
				}
			}
		} catch (IOException e) {
			System.out.println("ファイルを開けません。");
		} finally {
			try {
				if (out != null) {
					out.close(); // 書き込み先を閉じる
				}
			} catch (IOException e) {
				System.out.println("ファイルを閉じられません。");
			}
		}
		System.out.println("終了。");
	}
}

/**
 * 初期化時に正規表現を入れることでFile配列に入れるパスの条件を決める。
 */
class FilesFilter implements FilenameFilter {
	private String str = "";

	/**
	 * @param str 正規表現
	 */
	public FilesFilter(String str) {
		this.str = str;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.matches(str); // 正規表現による判別
	}

}