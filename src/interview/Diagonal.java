package interview;

import java.util.*;

/*

Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.

    1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20
Diagonal printing of the above matrix is

    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20

 */

class Diagonal {
	public static void main(String[] args) {
		// hm -> key -> index of first element and value as list

		Diagonal obj = new Diagonal();
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

		HashMap<int[], List<Integer>> hm = obj.firstElementDia(matrix);

		for (int[] arr : hm.keySet()) {
			System.out.println(arr[0] + " " + arr[1]);
		}

		System.out.println();
		for (int[] arr : hm.keySet()) {
			hm.put(arr, obj.diagonalElements(arr[0], arr[1], matrix));
		}

		for (List<Integer> list : hm.values()) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		// List<Integer> list = obj.diagonalElements(1,0, matrix);
		// for(int i:list) {
		// System.out.print(i+" ");
		// } // 9 6 3
	}

	public HashMap<int[], List<Integer>> firstElementDia(int[][] matrix) {

		HashMap<int[], List<Integer>> hm = new HashMap<>();

		int x = matrix.length - 1;
		for (int j = 1; j < matrix[x].length; j++) {
			int arr[] = { x, j };
			hm.put(arr, null);
		}

		for (int j = 0; j < matrix.length; j++) {
			int arr[] = { j, 0 };
			hm.put(arr, null);
		}
		return hm;
	}

	public List<Integer> diagonalElements(int x, int y, int[][] matrix) {
		List<Integer> neighbor = new ArrayList<>();

		while (x >= 0 && y < matrix[x].length) {
			neighbor.add(matrix[x][y]);
			x--;
			y++;
		}
		return neighbor;
	}
}
