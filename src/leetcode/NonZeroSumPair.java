package leetcode;

import java.util.ArrayList;

//https://leetcode.com/contest/weekly-contest-171/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
public class NonZeroSumPair {

	public static void main(String args[]) {
		NonZeroSumPair obj = new NonZeroSumPair();
		// System.out.println(20%10);
		for (int i : obj.getNoZeroIntegers(1010))
			System.out.println(i);
	}

	public int[] getNoZeroIntegers(int n) {
		int j =1;
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		str1.insert(0,n-j);
		str2.insert(0,j);
		
		while (str1.toString().indexOf("0")!=-1 || str2.toString().indexOf("0")!=-1) {
			j++;
			str1.delete(0, str1.length());
			str2.delete(0, str2.length());
			str1.insert(0,n-j);
			str2.insert(0,j);
		}
		
		int[] arr2 = new int[2];
		arr2[0] = Integer.parseInt(str1.toString());
		arr2[1] = Integer.parseInt(str2.toString());
		
		return arr2;
	}
}
