package inada;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class KadaiSuper {

	File file;
	File[] listA;
	File[] listB;
	String hikisu;

	int i;
	File newFileA;
	File newFileB;

	FilenameFilter filterA;
	FilenameFilter filterB;

	final String PATH = "c:/Users/稲田/Downloads/DATA/DATA/";//定数化
	final String NAME_A = "DATA_A_TOTAL.csv";
	final String NAME_B = "DATA_B_TOTAL.csv";

	//フィルタを作成
	public FilenameFilter filterCreate(String data) {

		FilenameFilter ff = new FilenameFilter() {

			public boolean accept(File file, String str) {

				//指定文字列でフィルタする
				//indexOfは指定した文字列が見つからなかったら-1を返す
				if (str.indexOf(data) != -1) {
					return true;
				} else {
					return false;
				}
			}
		};
		return ff;
	}

	public void syutoku() {
		file = new File(hikisu);

		filterA = filterCreate("DATA_A");
		filterB = filterCreate("DATA_B");

		//listFilesメソッドを使用して一覧を取得する
		listA = file.listFiles(filterA);
		listB = file.listFiles(filterB);
	}

	public void fileCreate() {//staticなるべく使わない
		//ファイルを用意
		newFileA = new File(PATH + NAME_A);//定数
		newFileB = new File(PATH + NAME_B);

		if ((listA == null) || (listB == null)) {
			System.out.println("指定されたファイルはありません。");
			System.exit(0);
		}
		//作成
		try {
			newFileA.createNewFile();//意図は?
			newFileB.createNewFile();
			System.out.println("ファイルの作成に成功しました。");

		} catch (IOException e) {
			System.out.println("ファイルの作成に失敗しました。");
		}

	}

	//コピーメソッドを回すメソッド
	public void callCopy(File fi, File[] list) {

		for (i = 0; i < list.length; ++i) {
			//コピーメソッド呼び出し
			try {
				copy(fi, list[i]);
			} catch (FileNotFoundException e) {
				System.out.println("ファイルのコピーに失敗しました。");
				System.exit(0);
			} catch (IOException e) {
				System.out.println("ファイルの読み込みに失敗しました。");
				System.exit(0);
			}

		}
	}

	//コピーして追記
	public void copy(File newFile, File nakami) throws FileNotFoundException, IOException {
		File inputFile = new File(nakami.toString());
		File outputFile = new File(newFile.toString());

		FileInputStream in = new FileInputStream(inputFile);
		FileOutputStream out = new FileOutputStream(outputFile, true);

		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}

		try {
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
