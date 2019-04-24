package inada;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncodeDecodePractice1 {

	public static void main(String[] args) {
		File outputFile = new File("c:\\output\\test.txt");

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(outputFile));

			String line;
			line = "hogehoge";
			out.write(line);

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {
					out.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("保存しました！");
	}

}
