package practiceSeqArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class ThreeSum {
	public static void main(String args[]) {
		ThreeSum obj = new ThreeSum();
		int arr[] = {-1, 0, 1, 2, -1, -4};
		ArrayList<ArrayList<Integer>> op = obj.getSets(arr);
		for (int i = 0;i<op.size();i++) {
			for (int j=0;j<op.get(0).size();j++) {
				System.out.print(op.get(i).get(j));
			}
			System.out.println("");
				
		}
			
	}

	public ArrayList<ArrayList<Integer>> getSets(int arr[]) {
		ArrayList<ArrayList<Integer>> op;
		
		int num;
		int target = 0;
		HashSet<ArrayList<Integer>> h1 = new HashSet<>();
		for (int i=0;i<arr.length-2;i++) {
			num = target-arr[i];
			HashSet<Integer> h2 = new HashSet<>();
			for (int j = i+1;j<arr.length;j++) {
				
				if (h2.contains(arr[j])) {
					ArrayList<Integer> aList = new ArrayList<>();
					aList.add(arr[i]);
					aList.add(arr[j]);
					aList.add(num-arr[j]);
					Collections.sort(aList);
					h1.add(aList);
				} else {
					h2.add(num-arr[j]);
				}
				
			}
		}
		
		op = new ArrayList<ArrayList<Integer>>(h1);
		return op;
	}
}
