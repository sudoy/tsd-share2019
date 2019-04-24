package fujinoki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample11_3 {
	public static void main(String[] artus) {
		//ストリームを開く
		File inputFile = new File("C:\\java\\test.txt");
		File outputFile = new File("C:\\java\\testcopy.text");
		FileOutputStream out = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(inputFile);
			out = new FileOutputStream(outputFile);
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
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
}
