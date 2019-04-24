package suzuki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sample11_6 {

	public static void main(String[] args) {



		File inputFile = new File("C:\\java\\test_buf.txt");
		File outputFile = new File("C:\\java\\test_bufcopy.txt");

		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			//開く
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));

			//読み書き
			String line;
			while((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//閉じる
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
