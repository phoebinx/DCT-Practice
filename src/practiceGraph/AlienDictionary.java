package practiceGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html

public class AlienDictionary {
	String[] arr = { "wrt", "wrf", "er", "ett", "rftt" };
//	String arr[] = { "z", "x", "z" };
	HashMap<Character, Set<Character>> hm = new HashMap<>(); // adjacency list graph
	Stack<Character> stack = new Stack<>();

	public static void main(String args[]) {
		AlienDictionary obj = new AlienDictionary();
		obj.BuildGraph();
		if (obj.TopologicalSort()) {
			while (!obj.stack.isEmpty()) {
				System.out.println(obj.stack.pop());
			}
		} else {
			System.out.println("");
		}
	}

	public void BuildGraph() {
		// filling hashmap keys with unique characters
		for (String str : arr) {
			for (Character c : str.toCharArray()) {
				if (!hm.containsKey(c))
					hm.put(c, new HashSet<Character>());
			}
		}
		// filling graph edges
		for (int i = 1; i < arr.length; i++) {
			String str2 = arr[i];
			String str1 = arr[i - 1];
			int len = Math.min(str1.length(), str2.length());
			for (int j = 0; j < len; j++) {
				if (str1.charAt(j) != str2.charAt(j)) {
					char out = str1.charAt(j);
					char in = str2.charAt(j);
					if (!hm.get(out).contains(in)) {
						hm.get(out).add(in);
					}
				}
			}
		}
	}

	public boolean TopologicalSort() {
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> recStack = new HashSet<>();
		for (Character c : hm.keySet()) {
			if (!visited.contains(c)) {
				if (!TopologicalSortUtil(visited, recStack, c))
					return false;
			}
		}
		return true;
	}

	public boolean TopologicalSortUtil(HashSet<Character> visited, HashSet<Character> recStack, Character c) {
		if (recStack.contains(c))
			return false;
		if (visited.contains(c))
			return true;
		recStack.add(c);
		visited.add(c);
		for (Character neighbor : hm.get(c)) {
			if (!TopologicalSortUtil(visited, recStack, neighbor))
				return false;
		}
		recStack.remove(c);
		stack.add(c);
		return true;
	}
}
