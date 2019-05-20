package kobayashi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

class Kadai3 {

	 String dir = "C:\\DATA\\DATA\\";
	 String fileA = "DATA_A_TOTAL.csv";
	 String fileB = "DATA_B_TOTAL.csv";

	 File fA;
	 File fB;

	 File[] listA;//一覧を取得
	 File[] listB;
	 File path;//共通


	BufferedReader in = null;
	BufferedWriter out = null;

	public void existcheck() {//TOTALファイルの存在チェック、作成

		try {
			if (!fA.exists() && fB.exists()) {
				fA.createNewFile();
				fB.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("エラーが発生しました。");
		}
	}

	public FilenameFilter filter() {//フィルタ

		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File inputFile, String name) {
				if (name.indexOf("DATA_A") != -1) {
					return true;
				} else {
					return false;
				}
			}
		};
		return filter;

		//File[] listA = .listFiles(filter); //ABにフィルタした到達不能コードと出る

	}
	public void getList() {

	}

	public void inputoutput(File[] list) {//読み込みと書き込み

		File outputFile = new File(list.toString());

			for (int i = 0; i < list.length; i++) {
				try {
					in = new BufferedReader(new FileReader(list[i]));
					out = new BufferedWriter(new FileWriter(outputFile,true));

					String line;
					while ((line = in.readLine()) != null) {
						out.write(line);
						out.newLine();
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
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
					try {
						if (out != null) {
							out.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("完了");
	}
}

class Kadai4 extends Kadai3 {

}

interface Comparator {
	void comp();
}

/*class CompImpl implements Comparator <File>{ インターフェース

	@Override
	public void comp() {
		Arrays.sort(listB, new Comparator<File>() {
			public int compare(File1 fileB,  File CompImpl) {
				return File.getOutputFileB() - File.();
			}
		});
		}

}*/

public class Kadai3_0516_ {//メイン

	public static void main(String[] args) {

		Kadai3 k3 = new Kadai3();

		k3.existcheck();
		k3.inputoutput();
	}
}
