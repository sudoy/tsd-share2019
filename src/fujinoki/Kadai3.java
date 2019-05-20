package fujinoki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class Kadai3 {
	public static void main(String[] args) throws IOException {
		File inputFile = null;
		File outputFile = null;
		FileInputStream in = null;
		FileOutputStream out = null;

		File dir = new File(args[0]);
		//ファイルの一覧を取得
		File[] list = dir.listFiles();

		//フィルタを作成する
		FilenameFilter filter = new FilenameFilter() {

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

		//“DATA_A”が含まれるフィルタを作成する
		File[] files = new File("C:\\java\\DATA").listFiles(filter);

		//結果を出力する
		for (int i = 0; i < files.length; ++i) {
			System.out.println(files[i]);
		}
	
		File filea = new File("c:\\Test1");

		if (filea.mkdir()) {
			System.out.println("フォルダの作成に成功しました");
		} else {
			System.out.println("フォルダの作成に失敗しました");
		}
	}

}