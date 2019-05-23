package kobayashi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Kadai3 {

	File fileA = new File("DATA_A_TOTAL.csv");
	File fileB = new File("DATA_B_TOTAL.csv");
	File allfile;//C:\DATA\DATA
	String filenameA = "DATA_A_";
	String filenameB = "DATA_B_";

	File[] listA;//一覧を取得
	File[] listB;

	BufferedReader in = null;
	BufferedWriter out = null;

	public void existcheck() throws NullPointerException {//指定したフォルダの存在チェック

		if (!allfile.exists()) {
			throw new NullPointerException();
		}
	}

	public FilenameFilter filter(String filename) {//フィルタ

		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File inputFile, String name) {
				if (name.indexOf(filename) != -1) {
					return true;
				} else {
					return false;
				}
			}
		};
		return filter;

	}

	public void getList() {//ABの一覧を取得

		listA = allfile.listFiles(filter(filenameA));
		listB = allfile.listFiles(filter(filenameB));

	}

	public void inputoutput(File[] list, File file) {//読み込みと書き込み

		for (int i = 0; i < list.length; i++) {
			try {
				in = new BufferedReader(new FileReader(list[i]));
				out = new BufferedWriter(new FileWriter(allfile.getPath() + file.getPath(), true));

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

class Comp implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {

		return (o2).compareTo(o1);
	}

}

public class Kadai3_0516_ {//メイン

	public static void main(String[] args) {

		Kadai3 k3 = new Kadai3();
		Comp c = new Comp();

		try {

			k3.allfile = new File(args[0]);
			k3.existcheck();
			k3.filter(k3.filenameA);
			k3.filter(k3.filenameB);
			k3.getList();
			k3.inputoutput(k3.listA, k3.fileA);
			Arrays.sort(k3.listB,c);//B配列 逆
			k3.inputoutput(k3.listB, k3.fileB);

		} catch (NullPointerException ne) {
			System.out.println("指定されたフォルダは存在しません。");
		}

	}
}

