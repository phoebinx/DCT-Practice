package interview;

import java.util.ArrayList;
import java.util.HashSet;
//https://leetcode.com/problems/knight-dialer/
//dabba
public class ChessKnightDial {
	int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { Integer.MIN_VALUE, 0, Integer.MIN_VALUE } };
	HashSet<ArrayList<Integer>> hs = new HashSet<>();
	int total = 7;

	public static void main(String args[]) {
		ChessKnightDial obj = new ChessKnightDial();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(obj.matrix[0][0]);
		obj.getPath(0, 0, arr);
		for (ArrayList<Integer> arr1: obj.hs) {
			for (int i : arr1) 
				System.out.print(i+" ");
			System.out.println();
		}
	}

	public void getPath(int i, int j, ArrayList<Integer> arr) {
		if (arr.size() >= total) {
			hs.add(arr);
			return;
		}

		int x[] = { 1, 2, -1, -2, 1, 2, -1, -2 };
		int y[] = { 2, 1, -2, -1, -2, -1, 2, 1 };

		for (int k = 0; k < 8; k++) {
			if (isSafe(i + x[k], j + y[k])) {
				ArrayList<Integer> newArr = new ArrayList<>(arr);
				newArr.add(matrix[i+x[k]][j+y[k]]);
				getPath(i + x[k], j + y[k], newArr);
			}
		}
	}

	public boolean isSafe(int i, int j) {
		if (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && matrix[i][j] != Integer.MIN_VALUE)
			return true;
		return false;
	}
}
