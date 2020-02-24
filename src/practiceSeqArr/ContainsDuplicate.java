package practiceSeqArr;

import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
 public static void main(String args[]) {
	 ContainsDuplicate obj = new ContainsDuplicate();
	 int arr[] = {1,1,1,3,3,4,3,2,4,2};
	 System.out.println(obj.hasDuplicate(arr));
 }
 
 public boolean hasDuplicate(int arr[]) {
	 HashSet<Integer> hs = new HashSet<>();
	 for (int i:arr) {
		 if (hs.contains(i))
			 return true;
		 hs.add(i);
	 }
	 return false;
 }
}
