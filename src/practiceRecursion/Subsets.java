package practiceRecursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets {
	public static void main(String args[]) {
		int nums[] = { 1, 2, 3 };
		Subsets obj = new Subsets();
		List<List<Integer>> subsets = obj.subsets(nums);
		for (List<Integer> list : subsets) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length <= 0)
			return null;
		return subsetsUtil(nums, 0);
	}

	public List<List<Integer>> subsetsUtil(int[] nums, int index) {
		if (index == nums.length)
			return null;
		List<List<Integer>> subsets;

		if (index == nums.length - 1) {
			subsets = new ArrayList<List<Integer>>();
			List<Integer> arr = new ArrayList<>();
			subsets.add(arr);
		} else {
			subsets = subsetsUtil(nums, index + 1);
		}
		List<List<Integer>> subsetsNew = new ArrayList<List<Integer>>(subsets);
		for (List<Integer> list : subsets) {
			List<Integer> listNew = new ArrayList<>(list);
			listNew.add(nums[index]);
			subsetsNew.add(listNew);
		}
		return subsetsNew;
	}
}
