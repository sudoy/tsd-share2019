package suzuki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample11_3 {

	public static void main(String[] args) {


		File inputFile = new File("C:\\java\\test.txt");
		File outputFile = new File("C:\\java\\testcopy.txt");

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			//開く
			in = new FileInputStream(inputFile);
			out = new FileOutputStream(outputFile);

			//読み書き //開けないと読み取り云々できないから同じ場所でOK
			int c;
			while((c = in.read()) != -1){
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {

			//閉じる
			try {
				if(in != null) { //NullPointerException防止
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(out != null) { //片方がエラーになったとき用に分けてる
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
