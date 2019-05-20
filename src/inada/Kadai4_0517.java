package inada;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Kadai4_0517 extends KadaiSuper {

	public static void main(String[] args) {
		Kadai4_0517 k = new Kadai4_0517();

		k.hikisu = args[0].toString();

		ReverseSort rs = new ReverseSort();

		k.syutoku();
		k.fileCreate();

		//Bを逆順に
		Arrays.sort(k.listB, rs);// (配列, Comparator<File>のオブジェクト)

		k.callCopy(k.newFileA, k.listA);
		k.callCopy(k.newFileB, k.listB);
	}

}

//逆順
class ReverseSort implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {

		int ret1 = Integer.parseInt(o1.toString().replaceAll("[^0-9]", ""));
		int ret2 = Integer.parseInt(o2.toString().replaceAll("[^0-9]", ""));

		return ret1 < ret2 ? 1 : -1;
	}
}