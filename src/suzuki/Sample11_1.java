package suzuki;

import java.io.File;
import java.io.IOException;

public class Sample11_1 {

	public static void main(String[] args) {

		try {
			File f1 = new File("C:\\ocjp");
			File f2 = new File(".","temp/log.txt");
			File f3 = new File(f1,"./Sample.java");

			System.out.println("path for f1: " + f1.getCanonicalPath());
			System.out.println("path for f2: " + f2.getCanonicalPath());
			System.out.println("path for f3: " + f3.getCanonicalPath());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
