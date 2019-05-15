package fujinoki;

import java.util.HashMap;
import java.util.Map;

public class Sample12_7 {


	public static void main(String[] args) {
		Map<String,String>map = new HashMap<>();
		map.put("1","aaa" );
		map.put("2","bbb");

		for(String s : map.keySet()) {
			System.out.print(s + " ");

		}
		System.out.println();

		for(String s : map.values()) {
			System.out.print(s + " ");
		}
		System.out.println();

		for(Map.Entry<String,String> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
