package fujinoki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//filenotfounds
//読込分けて出す
public class Rensyu_4 {
	public static void main(String[] args) {

		File file = new File("C:\\java\\DATA\\DATA_A_20160227.csv");

		FileReader fr = null;
		try {

			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String text;
		try {
			File filea= new File("C:\\java\\DATA\\DATA_A_20160227.csv");
			FileWriter totala = new FileWriter("C:\\java\\DATA\\DATA_A_TOTAL.csv");
			PrintWriter pw = new PrintWriter(new BufferedWriter(filea));

			while ((text = br.readLine()) != null) {
			}
			pw.println(text);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}