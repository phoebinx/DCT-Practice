package interview;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/diagonal-traverse/
//https://medium.com/@lenchen/leetcode-498-diagonal-traverse-7f616ee74ec4
public class Diagonal3 {
	int matrix[][];

	public static void main(String args[]) {
		Diagonal3 obj = new Diagonal3();
		obj.matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int arr[] = obj.findDiagonalOrder(obj.matrix);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		int arr[] = {};
		int m = matrix.length;
		if (m == 0)
			return arr;
		int n = matrix[0].length;
		boolean up = true;// down-> false, up-> true
		int i = 0, j = 0;

		List<Integer> list = new ArrayList<>();
		for (int k = 0; k < m * n; k++) {
			list.add(matrix[i][j]);
			// depending on the flag, go up or down
			if (up) { // up
				//last col while going up
				if (j == n - 1 && i + 1 < m) {
					i = i + 1;
					up = !up;
				} else if (i == 0 && j + 1 < n) { //first row -> go right
					j = j + 1;
					up = !up;
				} else {
					// up
					i = i - 1;
					j = j + 1;
				}
			} else { //down
				// last row going down -> go right
				if (i == m - 1 && j + 1 < n) {
					j = j + 1;
					up = !up;
				} else if (j == 0 && i + 1 < m) { //first col going down -> go down
					i = i + 1;
					up = !up;
				} else {// down
					i = i + 1;
					j = j - 1;
				}
			}
		}
		return list.stream().mapToInt(x -> x).toArray();
	}
}
