package practiceGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintCourseSchedule {
	int courseInDegree[];

	public static void main(String args[]) {
		PrintCourseSchedule obj = new PrintCourseSchedule();
		int prereq[][] = { { 1, 0 } };
		int n = 2;
		int[] res = obj.findOrder(n, prereq);
		for (int i : res)
			System.out.print(i + " ");

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		courseInDegree = new int[numCourses];
		HashMap<Integer, List<Integer>> pcMap = new HashMap<>();
		populatePrereqMapCourse(pcMap, prerequisites);
		Queue<Integer> courseToTake = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (courseInDegree[i] == 0)
				courseToTake.add(i);
		}
		ArrayList<Integer> order = new ArrayList<>();
		while (!courseToTake.isEmpty()) {
			int course = courseToTake.poll();
			order.add(course);
			if (pcMap.containsKey(course)) {
				for (int neighbor : pcMap.get(course)) {
					if (--courseInDegree[neighbor] == 0)
						courseToTake.add(neighbor);
				}
			}
		}
		return (order.size() == numCourses ? (order.stream().mapToInt(i -> i).toArray()) : new int[0]);
	}

	private void populatePrereqMapCourse(HashMap<Integer, List<Integer>> pcMap, int[][] prerequisites) {
		for (int[] pair : prerequisites) {
			int x = pair[0];
			int y = pair[1];
			if (!pcMap.containsKey(y))
				pcMap.put(y, new ArrayList<>());
			pcMap.get(y).add(x);
			courseInDegree[x]++;
		}
	}

}

//Stack<Integer> courseStack = new Stack<>();
//int numCourses;
//int[][] prerequisites;
//HashMap<Integer, HashSet<Integer>> relation;
//HashSet<Integer> visited;
//HashSet<Integer> recStack;

//	private int[] findOrder(int numCourses, int[][] prerequisites) {
//		if (numCourses == 1 && prerequisites.length == 0)
//			return new int[] { 0 };
//		if (prerequisites.length == 0) {
//			int[] res = new int[numCourses];
//			for (int i = 0; i < numCourses; i++)
//				res[i] = i;
//			return res;
//		}
//
//		this.numCourses = numCourses;
//		this.prerequisites = prerequisites;
//		this.relation = buildPrereq();
//		return takeCourse();
//	}
//
//	private HashMap<Integer, HashSet<Integer>> buildPrereq() {
//		HashMap<Integer, HashSet<Integer>> relation = new HashMap<>();
//		// create pre req map A->B,C where B & C need to be take n to take A.
//
//		for (int i = 0; i < prerequisites.length; i++) {
//			if (!relation.containsKey(prerequisites[i][0]))
//				relation.put(prerequisites[i][0], new HashSet<Integer>());
//			if (!relation.containsKey(prerequisites[i][1]))
//				relation.put(prerequisites[i][1], new HashSet<Integer>());
//			relation.get(prerequisites[i][0]).add(prerequisites[i][1]);
//		}
//
//		for (Integer i : relation.keySet()) {
//			if (relation.get(i) == null) {
//				courseStack.add(i);
//			}
//		}
//		// System.out.println(courseStack);
//		return relation;
//	}
//
//	private int[] takeCourse() {
//		visited = new HashSet<>();
//		recStack = new HashSet<>();
//
//		for (Integer course : relation.keySet()) {
//			if (!visited.contains(course)) {
//				if (takeCourseUtil(course))
//					return new int[] {};
//			}
//		}
//
//		return courseStack.stream().mapToInt(i -> i).toArray();
//	}
//
//	private boolean takeCourseUtil(Integer course) {
//		if (recStack.contains(course))
//			return true; // can't, there is cycle
//		if (visited.contains(course))
//			return false;
//		if (relation.get(course)==null)
//			return false;
//		
//		recStack.add(course);
//		visited.add(course);
//		
//
//		for (Integer preReq : relation.get(course)) {
//			if (takeCourseUtil(preReq))
//				return true;
//		}
//		courseStack.add(course);
//		recStack.remove(course);
//		return false;
//	}
//
//}
