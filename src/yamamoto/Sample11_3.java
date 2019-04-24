package yamamoto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample11_3 {

	public static void main(String[] args) {
		File inputfile = new File("C:\\java\\test.txt"); // 読み込み元のファイルアドレス
		File outputfile = new File("C:\\java\\testout2.txt"); // 書き込み先のファイルアドレス
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			// ストリームを開く
			in = new FileInputStream(inputfile);
			out = new FileOutputStream(outputfile);
			// 読み込み書き込み
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ストリームを閉じる
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

}
