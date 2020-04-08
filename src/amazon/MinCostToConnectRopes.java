package amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/344677
public class MinCostToConnectRopes {
	public static void main(String args[]) {
		MinCostToConnectRopes obj = new MinCostToConnectRopes();
		Integer ropes[] = { 2, 2, 3, 3 };
		System.out.println(obj.minCost(ropes));
	}

	public int minCost(Integer[] ropes) {
		int cost = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i,j) -> {
			return((int)i - (int)j);
		});
		List<Integer> ropeList = Arrays.asList(ropes);
		pq.addAll(ropeList);
		int sum = pq.poll();
		while(!pq.isEmpty()) {
			sum = sum + pq.poll();
			cost = cost + sum;
			pq.add(sum);
			sum =pq.poll();
		}
		return cost;
	}

}
