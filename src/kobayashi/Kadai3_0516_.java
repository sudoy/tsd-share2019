package kobayashi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class Kadai3 {

	File inputFile = new File("C:\\kadai\\DATA\\DATA\\");//引数に渡す値

	File outputFileA = new File("C:\\kadai\\DATA\\DATA\\DATA_A_TOTAL.csv");
	File outputFileB = new File("C:\\kadai\\DATA\\DATA\\DATA_B_TOTAL.csv");

	BufferedReader in = null;
	BufferedWriter out = null;

	File[] list = inputFile.listFiles();

	public void existcheck() {//TOTALファイルの存在チェック、作成

		try {
			if (!outputFileA.exists() && outputFileB.exists()) {
				outputFileA.createNewFile();
				outputFileB.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("エラーが発生しました。");
		}
	}

	public void ioA() {//読み込みと書き込みA

		if (list != null) {//DATA_A

			for (int i = 0; i < 100; i++) {
				try {
					in = new BufferedReader(new FileReader(list[i]));
					out = new BufferedWriter(new FileWriter(outputFileA, true));

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
			System.out.println("A完了");
		} else {
			System.out.println("null");
		}
	}

	public void ioB() {//読み込みと書き込みB
		if (list != null) {///DATA_B

			for (int j = 100; j < 110; j++) {
				try {
					in = new BufferedReader(new FileReader(list[j]));
					out = new BufferedWriter(new FileWriter(outputFileB, true));

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
			System.out.println("B完了");
		} else {
			System.out.println("null");
		}
	}
}

class Kadai4 extends Kadai3 {

}

interface Comparator {
	void comp();
}

class CompImpl implements Comparator {

	@Override
	public void comp() {
		Comparator<File> c = new Comparator<File>();


		public int compare(File o1, File o2) {

			Arrays.sort(list,);
		}

	}
}

public class Kadai3_0516_ {//メイン

	public static void main(String[] args) {

		Kadai3 k3 = new Kadai3();

		k3.existcheck();
		k3.ioA();
		k3.ioB();
	}
}
