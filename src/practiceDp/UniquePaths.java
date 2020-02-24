package practiceDp;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
	int m = 7;
	int n = 3;
	int arr[][] = new int[m][n];
	
	public static void main(String args[]) {
		UniquePaths obj = new UniquePaths();
		
		for(int i =0;i<obj.arr.length;i++) {
			Arrays.fill(obj.arr[i], -1);
		}
		
		System.out.println(obj.totalPath(0,0));
	}
	
	public int totalPath(int i,int j) {
		if(i>=m || j>=n)
			return 0;
		if (arr[i][j] !=-1) {
			return arr[i][j];
		}
		if(i==m-1 && j==n-2)
			return 1;
		if(i==m-2 && j==n-1)
			return 1;
		
		arr[i][j] = totalPath(i+1,j)+totalPath(i,j+1);
		return arr[i][j];
	}

}
