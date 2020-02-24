package practiceSeqArr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
	public static void main(String args[]) {
		int arr[] = {2,7,11,15};
		int target = 17;
		TwoSum obj = new TwoSum();
		System.out.println(obj.getTwoSum(arr,target));
	}
	
	public List<Integer> getTwoSum(int arr[], int target) {
		List<Integer> res = new ArrayList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if (map.containsKey(arr[i])) {
				res.add(map.get(arr[i]));
				res.add(i);
			} else {
				map.put(target-arr[i], i);
			}
		}
		return res;
	}
}
