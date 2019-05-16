package kobayashi;

import java.io.File;

public class Kadai0516_2 {

	public static void main(String[] args) {


		File file1 = new File("C:\\kadai\\DATA\\DATA\\");
		File[] list = file1.listFiles();

		//DATA_AとDATA_Bを分ける

				//DATA_A
				if (list != null) {

					for (int i = 0; i < 100; i++) {
						System.out.println(list[i]);
					}
				} else {
					System.out.println("null");
				}

				//DATA_B
				if (list != null) {

					for (int j = 100; j < 110; j++) {
						System.out.println(list[j]);
					}
				} else {
					System.out.println("null");
				}
	}

}
