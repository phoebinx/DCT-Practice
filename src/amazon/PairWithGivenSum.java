package amazon;

import java.util.HashMap;

//https://leetcode.com/discuss/interview-question/356960
public class PairWithGivenSum {
	public static void main(String args[]) {
		PairWithGivenSum obj = new PairWithGivenSum();
//		int nums[] = { 0, 50, 40, 25, 30, 10 };
//		int target = 90;
		int nums[] = { 0, 0 };
		int target = 30;
		int res[] = obj.largestPairSum(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}

	public int[] largestPairSum(int nums[], int target) {
		int max = Integer.MIN_VALUE;
		int newTarget = target - 30;
		int res[] = new int[] { -1, -1 };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (nums[i] > max || nums[map.get(nums[i])] > max) {
					res[0] = map.get(nums[i]);
					res[1] = i;
				}
			} else {
				map.put(newTarget - nums[i], i);
			}
		}

		return res;
	}

}
