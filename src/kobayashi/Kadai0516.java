package kobayashi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Kadai0516 {

	public static void main(String[] args) {

		File inputFile = new File("C:\\kadai\\DATA\\DATA\\");//引数に渡す値

		File outputFileA = new File("C:\\kadai\\DATA\\DATA\\DATA_A_TOTAL.csv");
		File outputFileB = new File("C:\\kadai\\DATA\\DATA\\DATA_B_TOTAL.csv");

		BufferedReader in = null;
		BufferedWriter out = null;

		File[] list = inputFile.listFiles();

		//TOTALファイルの存在チェック、作成
		try {
			if (!outputFileA.exists() && outputFileB.exists()) {
				outputFileA.createNewFile();
				outputFileB.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("エラーが発生しました。");
		}

		//読み込みと書き込み

		//DATA_A
		if (list != null) {

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
		} else {
			System.out.println("null");
		}

		///DATA_B
		if (list != null) {

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

		} else {
			System.out.println("null");
		}
	}

}
