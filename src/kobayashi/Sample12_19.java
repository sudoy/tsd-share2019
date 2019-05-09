package kobayashi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sample12_19 {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();

		array.add(1);
		array.add(12);
		array.add(123);
		array.add(1234);
		array.add(12345);

		//偶数だけ表示
		//JDK7までの書き方
		System.out.println("拡張for文を利用");
		for (int num : array) {
			if (num % 2 == 0) {
				System.out.println(num + " ");
			}
		}

		System.out.println();

		//Stream API を利用した書き方
		System.out.println("Stream APIを利用");
		array.stream()//streamの取得
				.filter(num -> num % 2 == 0) //中間処理(条件に合った要素だけを取り出す)//trueのものだけ抽出
				.forEach(i -> System.out.print(i + " ")); //終端処理(取り出された数字を表示)

		System.out.println();
		System.out.println("--------------------");

		//1000以下の奇数だけ取り出して新しいArrayListを作成する
		//JDK 7までの書き方
		System.out.println("拡張for文 + if文");
		List<Integer> intArray1 = new ArrayList<>();
		for (int num : array) {
			if (num % 2 == 1) {
				if (num <= 1000) {
					intArray1.add(num);
				}
			}
		}
		System.out.println("intArray1 :" + intArray1);

		//要素がセットに含まれていない場合
		//Stream API を利用した書き方
		System.out.println("Stream APIを使用");
		List<Integer> intArray2 = array.stream()
				.filter(num -> num % 2 == 1)
				.filter(num -> num <= 1000)
				.collect(Collectors.toList());

		System.out.println("intArray2 : " + intArray2);
	}
}
