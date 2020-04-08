package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class ThousandEyesExpiredache {
	class Val {
		String val;
		long timeStamp;

		Val(String val, long timeStamp) {
			this.val = val;
			this.timeStamp = timeStamp;
		}
	}

	HashMap<String, Val> cache = new HashMap<>();
	int size = 2;
	PriorityQueue<Map.Entry<String, Long>> queue = new PriorityQueue<>((e1, e2) -> {
		return (int) (e1.getValue() - e2.getValue());
	});
	HashSet<String> hs = new HashSet<>();

	public static void main(String args[]) {
		ThousandEyesExpiredache obj = new ThousandEyesExpiredache();
		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((e1, e2) -> {
			return e1.getValue() - e2.getValue();
		});
		q.add(obj.entry(1, 1));
		q.add(obj.entry(1, 2));
		for (Map.Entry<Integer, Integer> entry : q) {
			System.out.println(entry.getKey());
		}
		
 	}

	public Val get(String key) {
		if (!cache.containsKey(key))
			return null;

		Val val = cache.get(key);
		if (val.timeStamp < System.currentTimeMillis()) {
			cache.remove(key);
			return null;
		}
		return val;
	}

	public void set(String key, String val, long timestamp) {
		if (cache.size() >= size) {
			// while()
			// cache.remove(key);
		}
		cache.put(key, new Val(val, timestamp));
//		hs.add(key+val.timeStamp);
//		queue.add(entry(key+val.timeStamp, val.timeStamp));
	}

	public Map.Entry<String, Long> entry(String key, Long val) {
		return new Map.Entry<String, Long>() {

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return key;
			}

			@Override
			public Long getValue() {
				// TODO Auto-generated method stub
				return val;
			}

			@Override
			public Long setValue(Long value) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public Entry<Integer, Integer> entry(Integer key, Integer val) {
		return new Map.Entry<Integer, Integer>() {

			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return key;
			}

			@Override
			public Integer getValue() {
				// TODO Auto-generated method stub
				return val;
			}

			@Override
			public Integer setValue(Integer value) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
