package kobayashi;

import java.util.HashMap;
import java.util.Map;

public class Test0424 {

	public static void main(String[] args) {
		Map<String,String> map1 = new HashMap<>();
		map1.put("key1", "abc");
		map1.put("key2", "あいう");
		map1.put("key3","αβγ");

		System.out.println(map1.get("key1"));
		
		//Mapのループ(拡張for)
		for(Map.Entry<String,String> e : map1.entrySet()) {//右から1個取り出して左に入れてるを繰り返している
			System.out.println(e.getKey() + ":" + e.getValue());
		}

	}

}
