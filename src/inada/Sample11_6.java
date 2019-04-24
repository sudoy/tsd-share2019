package inada;

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
		BufferedWriter out = null;	//	ここPrintWriterにできる

		try {
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));//ここも

			String line;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();	//out.println(line);に代わる

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
				if (out != null) {//try-catchいらない（PrintWriterの場合）
					out.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
