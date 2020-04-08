package interview;

import java.util.HashMap;
import java.util.LinkedList;

public class ThousandEyeChache {
	class Node {
		int val;
		Node next;
		Node prev;
		Node(int val) {
			this.val = val;
			next = null;
			prev = null;
		}
	}
	class MyLL {
		HashMap<String, Node> hm = new HashMap<>();
	}
	HashMap<String, Integer> dict = new HashMap<>();
	LinkedList<String> lastAccessed = new LinkedList<>();
	public static void main(String args[]) {
		ThousandEyeChache obj = new ThousandEyeChache();
		
	}
	
	public Integer get(String key) {
		if (dict.containsKey(key)) {
			lastAccessed.remove(key);
			lastAccessed.addFirst(key);
			return dict.get(key);
		} 
		return null;
	}
	
	public void set(String key,int val ) {
		if (dict.containsKey(key)) {
			lastAccessed.remove(key);
		}
		lastAccessed.addFirst(key);
		dict.put(key, val);
	}
	
	public void remove(String key) {
		if (!dict.containsKey(key))
			return;
		dict.remove(key);
		lastAccessed.remove(key);//O(n)`
	}
	
	public String last() {
		if (lastAccessed.isEmpty())
			return null;
		return lastAccessed.getFirst();
	}
}
