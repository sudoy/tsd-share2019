package suzuki;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sample12_19 {

	public static void main(String[] args) {

		List<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(12);
		array.add(123);
		array.add(1234);
		array.add(12345);

		System.out.println("拡張for文を利用");
		for(int num : array) {
			if(num % 2 == 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println();


		System.out.println("Stream APIを利用");
		array.stream()
			.filter(num -> num % 2 == 0)
			.forEach(i -> System.out.print(i + " "));

		System.out.println();
		System.out.println("------------------------------");


		System.out.println("拡張for文＋if文");
		List<Integer> intArray1 = new ArrayList<>();
		for(int num : array) {
			if(num % 2 == 0) {
				if(num <= 1000) {
					intArray1.add(num);
				}
			}
		}
		System.out.println("intArray1：" + intArray1);


		System.out.println("Stream APIを利用");
		List<Integer> intArray2 = array.stream()
				.filter(num -> num % 2 == 1)
				.filter(num -> num <= 1000)
				.collect(Collectors.toList());
		System.out.println("intArray2：" + intArray2);
	}

}
