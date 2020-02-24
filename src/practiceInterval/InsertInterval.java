package practiceInterval;

import java.util.ArrayList;

//https://leetcode.com/problems/insert-interval/
//https://www.youtube.com/watch?v=Zk77nLzswSQ
public class InsertInterval {
	//int[][] interval = { { 1, 3 }, { 6, 9 } };
	int [][] interval = {{1,2},{3,5},{6,7},{8,10},{12,16}};
	int[] newInterval = { 4,8 };
	int[][] finalInterval;
	ArrayList<int[]> finalList = new ArrayList<>();

	public static void main(String args[]) {
		InsertInterval obj = new InsertInterval();
		obj.finalInterval = obj.mergeIntervals();
		for (int[] arr: obj.finalInterval) {
			System.out.println(arr[0]+" "+arr[1]);
		}
	}
	
	public int[][] mergeIntervals() {
		int newStart=newInterval[0], newEnd=newInterval[1];
		boolean flag = false;
		for(int i = 0;i<interval.length;i++) {
			if (interval[i][1] < newInterval[0]) {
				finalList.add(interval[i]);
			} else if(interval[i][0] <= newInterval[1]) {
				newStart = Math.min(interval[i][0], newStart);
				newEnd = Math.max(interval[i][1], newEnd);
			} else {
				if (!flag) {
					int arr[] = {newStart, newEnd};
					finalList.add(arr);
					flag=true;
				}
				finalList.add(interval[i]);
			}
		}
		
		if (!flag)
			finalList.add(newInterval);
		
		finalInterval = new int[finalList.size()][2];
		int i = 0;
		for (int [] arr:finalList) {
			finalInterval[i] = arr;
			i++;
		}
		
		return finalInterval;
	}
}
