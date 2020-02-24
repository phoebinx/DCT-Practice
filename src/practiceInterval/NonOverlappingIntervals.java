package practiceInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
	//int[][] input= {{1,2},{2,3},{3,4},{1,3}};
	//int[][] input= {{1,1000},{2,3},{3,4},{4,5}};
	//int[][] input= {{1,2},{1,2},{1,2}};
	int[][] input= {{1,2},{2,3}};
	public static void main(String args[]) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		//sort by end time
		Arrays.sort(obj.input,
				(int[] a, int [] b)-> {
					return a[1]-b[1];
				});
		
		System.out.println(obj.getNonOverlappingInterval());
	}
	
	public int getNonOverlappingInterval() {
		ArrayList<int[]> arr = new ArrayList<>(Arrays.asList(input));
		int count = 0;
		//iterate over input
		for (int i = 1;i<arr.size();i++) { 
			if (overlap(arr.get(i-1), arr.get(i))) {
				//arr.remove(i);
				count++;
			}
		}
		return count;
	}
	
	public boolean overlap(int[] a, int [] b) {
		if (a[0]<b[1] && b[0]<a[1])
			return true;
		return false;
	}
	
	public void increment(int i) {
		if (hm.containsKey(input[i])) {
			hm.put(input[i], hm.get(i)+1);
		} else {
			hm.put(input[i], 1);
		}
	}
}


// {1,1000), {2,3}, 4{5,} {5,6}
//here if we arrange by start time,
//1,1000 will stay so we should arrange
//by end time and remove overlapping interval
//which overlaps with its previous interval 