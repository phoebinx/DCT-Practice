package practiceDp;

import java.util.Arrays;

//https://leetcode.com/problems/combination-sum-iv/
public class CombinationSum {
	int nums[] = { 1, 2,3 };
	int target = 4;
	int dp[] = new int[target+1];

	public static void main(String args[]) {
		CombinationSum obj = new CombinationSum();
		Arrays.fill(obj.dp, -1);
		System.out.println(obj.totalCom(obj.target));
	}

	public int totalCom(int target) {
		if (dp[target]!=-1)
			return dp[target];
		if (target == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += totalCom(target - nums[i]);
			}
		}
		dp[target] = res;
		return res;
	}

}
