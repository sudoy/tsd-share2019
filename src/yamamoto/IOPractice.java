package yamamoto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOPractice {

	public static void main(String[] args) {
		File inputfile = new File("C:\\java\\test.txt");
		File outputfile = new File("C:\\java\\test.txt");
		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new FileReader(inputfile));
			out = new BufferedWriter(new FileWriter(outputfile));
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
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
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
