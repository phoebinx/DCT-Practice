package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/contest/weekly-contest-174/problems/reduce-array-size-to-the-half/
public class ReduceArraySizeToHalf {

	public static void main(String args[]) {
		ReduceArraySizeToHalf obj = new ReduceArraySizeToHalf();
		//int arr[] = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
		//obj.minSetSize(arr);
		List<Integer> hmValue = new ArrayList<>();
		hmValue.add(1);
		hmValue.add(2);
		hmValue.add(3);
		hmValue.add(4);
		System.out.println(obj.combo(hmValue,5));
	}

	public int minSetSize(int[] arr) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		//hm with key as array element and value as occurance 
		for (int i:arr) {
			if (hm.containsKey(i))
				hm.put(i, hm.get(i)+1);
			else
				hm.put(i,1);
		}
		List<Integer> hmValue = new ArrayList<>();
		//sort hm by occurance
		for (int entry : hm.values()) {
			hmValue.add(hm.get(entry));
		}

		Collections.sort(hmValue, (Integer hm1, Integer hm2) -> {
			return hm1 - hm2;
		});
		
		return combo(hmValue, arr.length/2);	
	}
	
	public int combo(List<Integer> hmValue, int total) {
		int index = findClosest(hmValue,total);
		
		if (hmValue.get(index)==total)
			return 1;
		
		int min;
		min = Integer.MAX_VALUE;
		
		int count = 0,sum = 0;
		for(int i = index;i>=0;i--) {
			sum = sum+hmValue.get(i);
			if (Math.abs(total-sum) < min) {
				min = Math.abs(total-sum);
				count = count+1;
			} else {
				break;
			}
		}
		if (index<hmValue.size() && min >Math.abs(hmValue.get(index+1)-total))
			return 1;
		return count;
	}

	public int findClosest(List<Integer> hmValue, int total) {
		int low = 0, high = hmValue.size()-1;
		int mid = 0;
		while(low<high) {
			mid = low+high/2;
			if (hmValue.get(mid)==total) {
				return mid;
			} else if (hmValue.get(mid)>total) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return mid;
	}
}
