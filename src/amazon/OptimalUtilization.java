package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/discuss/interview-question/373202
//https://codereview.stackexchange.com/questions/231991/optimal-utilization
public class OptimalUtilization {
	public static void main(String args[]) {
		OptimalUtilization obj = new OptimalUtilization();
//		int [][] a = {{1, 2}, {2, 4}, {3, 6}};
//		int [][] b = {{1, 2}};
//		int target = 7;
		int [][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int [][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int target = 10;

		for (List<Integer> list: obj.optimalPairs(a,b, target)) {
			System.out.println(list);
		}
	}
	
	public List<List<Integer>> optimalPairs(int [][]a, int [][]b, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int currentMax = Integer.MIN_VALUE;
		int sum;
		for (int i = 0;i<a.length;i++) {
			for (int j =0;j<b.length;j++) {
				sum = a[i][1]+b[j][1];
				if (sum > target) continue;
				if (sum>=currentMax) {
					if (sum>currentMax) {
						currentMax = sum;
						result.clear();
					}
					Integer entry[] = {a[i][0], b[j][0] };
					result.add(Arrays.asList(entry));
				}
			}
		}
		return result;
	}
}
