package leetcode;

//https://leetcode.com/contest/weekly-contest-170/problems/xor-queries-of-a-subarray/
public class XorQueriesSubarray {

	public static void main(String args[]) {
		XorQueriesSubarray obj = new XorQueriesSubarray();
		int arr[]= {4,8,2,10};
		int q[][] = {{2,3},{1,3},{0,0},{0,3}};
		for(int i : obj.xorQueries(arr, q) ) {
			System.out.println(i+" ");
		}
				
	}

	public int[] xorQueries(int[] arr, int[][] queries) {
		int op[] = new int[queries.length];
		
		for(int i=0;i<queries.length;i++) {
			for (int j = queries[i][0]; j<=queries[i][1];j++) {
				op[i] = op[i] ^ arr[j];
			}
		}
		return op;
	}
}
