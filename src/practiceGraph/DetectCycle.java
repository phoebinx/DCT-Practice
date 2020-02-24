package practiceGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/course-schedule/
public class DetectCycle {

	HashMap<Integer, LinkedList<Integer>> hm = new HashMap<>();
	int numCourses = 2;
	int[][] prerequisites = { {1,0},{0,1} };;

	public static void main(String args[]) {
		DetectCycle obj = new DetectCycle();

		for (int i = 0; i < obj.prerequisites.length; i++) {
			obj.addEdge(obj.prerequisites[i][0], obj.prerequisites[i][1]);
		}

		String output = obj.canFinish()==false ? "Can Finish" : "Can't finish";
		System.out.println(output);

	}

	public void addEdge(int a, int b) {
		if (hm.containsKey(a)) {
			LinkedList<Integer> l = hm.get(a);
			l.add(b);
			hm.put(a, l);
		} else {
			LinkedList<Integer> l = new LinkedList<>();
			l.add(b);
			hm.put(a, l);
		}
	}

	public boolean canFinish() {
		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> recStack = new HashSet<>();
		for (Integer key : this.hm.keySet()) {
			if (!visited.contains(key)) {
				if (this.canFinishUtil(visited, recStack, key))
					return true;
			}
		}
		return false;
	}

	public boolean canFinishUtil(HashSet<Integer> visited, HashSet<Integer> recStack, int key) {
		if (recStack.contains(key))
			return true;
		if (visited.contains(key))
			return false;

		recStack.add(key);
		visited.add(key);
		if (hm.containsKey(key)) {
			for (Integer neighbor : hm.get(key)) {
				if (canFinishUtil(visited, recStack, neighbor))
					return true;
			}
		}

		recStack.remove(key);
		return false;
	}
}
