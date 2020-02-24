package practiceSeqArr;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	HashMap<Integer, Integer> cache = new HashMap();
	LinkedList<Integer> order = new LinkedList();
	int maxCapacity;

	public static void main(String args[]) {
		LRUCache obj = new LRUCache();
		obj.maxCapacity = 2;
//		obj.put(1, 100);
//		obj.put(2,200);
//		System.out.println(obj.get(1));
//		System.out.println(obj.get(2));
//		obj.put(3, 300);
//		System.out.println(obj.get(1));
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1)); // returns 1
		obj.put(3, 3); // evicts key 2
		System.out.println(obj.get(2)); // returns -1 (not found)
		obj.put(4, 4); // evicts key 1
		System.out.println(obj.get(1)); // returns -1 (not found)
		System.out.println(obj.get(3)); // returns 3
		System.out.println(obj.get(4)); // returns 4
	}

	public void put(int key, int value) {
		if (order.size() == this.maxCapacity) {
			int lastKey = order.removeLast();
			cache.remove(lastKey);
		}
		cache.put(key, value);
		order.addFirst(key);

	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			order.remove((Integer) key);
			order.addFirst(key);
			return cache.get(key);
		}
		return -1;
	}
}

//Time complexity:
//put:
//O(1) -> Remove last linkedlist is O(1) and remove hashmap is O(1)
//get:O(n)
//O(1) -> containsKEy of hashmap is o(1), O(n) for remove of LL and O(1) for add first.