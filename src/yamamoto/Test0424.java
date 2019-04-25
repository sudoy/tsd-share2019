package yamamoto;

import java.util.HashMap;
import java.util.Map;

public class Test0424 {

	public static void main(String[] args) {

		Map<String, String> map1 = new HashMap<>();
		map1.put("key1","abc");
		map1.put("key2","あいう");
		map1.put("key3","αβγ");

		System.out.println(map1.get("key1"));

		for(Map.Entry<String, String> e : map1.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
