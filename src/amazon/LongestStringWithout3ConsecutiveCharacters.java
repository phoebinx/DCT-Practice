package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/330356
public class LongestStringWithout3ConsecutiveCharacters {
	class Node {
		int val;
		char letter;

		Node(int val, char letter) {
			this.val = val;
			this.letter = letter;
		}
	}

	public static void main(String args[]) {
		LongestStringWithout3ConsecutiveCharacters obj = new LongestStringWithout3ConsecutiveCharacters();
		int A = 1, B = 1, C = 6;
		Map<Character, Integer> map = obj.populateMap(A, B, C);
		System.out.println(obj.getCombo(map));
	}

	public String getCombo(Map<Character, Integer> map) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> {
			return (n1.val - n2.val)*-1;
		});
		
		for (Character c: map.keySet()) {
			if (map.get(c)!=0) {
				pq.offer(new Node(map.get(c),c));
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Node first = pq.poll();
			if (sb.length()!=0 && sb.charAt(sb.length()-1) == first.letter) {
				if (pq.isEmpty())
					return sb.toString();
				else {
					Node second = pq.poll();
					sb.append(second.letter);
					second.val--;
					if (second.val!=0)
						pq.offer(second);
					pq.offer(first);
				}
			} else {
				int limit = Math.min(2, first.val);
				for (int i = 0;i<limit;i++) { 
					sb.append(first.letter);
					first.val--;
				}
				if (first.val!=0) {
					pq.offer(first);
				}
			}
		}
		return sb.toString();
	}

	public Map<Character, Integer> populateMap(int A, int B, int C) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', A);
		map.put('b', B);
		map.put('c', C);
		return map;
	}

}
