package inada;

import inada.KadaiSuper;

public class Kadai3_0516 extends KadaiSuper {

	public static void main(String[] args) {
		Kadai3_0516 k = new Kadai3_0516();

		k.hikisu = args[0].toString();

		k.syutoku();

		k.fileCreate();

		k.callCopy(k.newFileA, k.listA);
		k.callCopy(k.newFileB, k.listB);
	}

}