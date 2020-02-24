package practiceInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/merge-intervals
public class MergeInterval {
//	int interval[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
	int interval[][] = { { 4, 5 }, { 1, 4 }};
	Stack<int[]> stack = new Stack<int[]>();
	ArrayList<int[]> list = new ArrayList<>();

	public static void main(String args[]) {
		MergeInterval obj = new MergeInterval();
		Arrays.sort(obj.interval, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});

		obj.mergeInterval();
		for (int arr[] : obj.stack) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}

	public void mergeInterval() {
		stack.push(interval[0]);
		int[] a;
		int[] b;
		for (int i = 1; i < interval.length; i++) {
			a = stack.peek();
			b = interval[i];
			if (a[0] < b[1] && b[0] <= a[1]) {
				stack.pop();
				stack.push(new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) });
			} else {
				stack.push(b);
			}
		}
	}
}
