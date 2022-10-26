package github.kimunche.dog;

import java.util.HashMap;
import java.util.Map;

public class Param {
	/**
	 * 이것도 나중에 더 줄일 수 있음.
	 * @param k1
	 * @param v1
	 * @param k2
	 * @param v2
	 * @return
	 */
	public static Map<String, Object> make(String k1, Object v1, String k2, Object v2) {
		Map<String, Object> param = new HashMap<>();
		param.put(k1, v1);
		param.put(k2, v2);
		return param;
	}
	public static Map<String, Object> make(String k1, Object v1) {
		Map<String, Object> param = new HashMap<>();
		param.put(k1, v1);
		return param;
	}
	/**
	 * 여러개짜리는 이걸 사용함
	 * make("age", 12, "name", "dkdk dkd", "hobby", "dd ddd");
	 * @param args - 짝수개 이어야함 index 0, 2, 4, ..는 String 이어야 함
	 * @return
	 */
	public static Map<String, Object> make(Object ... args) {
		Map<String, Object> param = new HashMap<>();
		for (int k = 0 ; k < args.length ; k += 2 ) {
			String key = (String) args[k];
			Object value = args[k+1];
			param.put(key, value);
		}
		return param;
	}
}
