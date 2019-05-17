package kobayashi;

import java.io.File;
import java.util.Arrays;

public class Kadai0517 {

	public static void main(String[] args) {

		File inputFile = new File("C:\\kadai\\DATA\\DATA\\");//ファイル全部
		File[] list = inputFile.listFiles();

		//逆順にソート

		    //A
			for (int i = 10; i < 110; i++) {
				System.out.println(list[i]);
			}
			//B
			for (int j = 0; j < 10; j++) {
				System.out.println(list[j]);
			}
	}
}
class Kadai0517_2 extends Kadai0517 implements Comparator{
	public int compare(File o1, File o2) {

		  return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));


}
interface aaa{
	Arrays.sort(list, Comparator.reverseOrder());
}


