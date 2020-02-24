package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class Diagonal2 {
	public static void main(String args[]) {
		Diagonal2 obj = new Diagonal2();
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		obj.util(matrix);
	}

	public void util(int[][] matrix) {
		Queue<String> q = new LinkedList<>();
		int x = matrix.length;
		int y = matrix[0].length;
		q.add(0 + "," + 0);
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				String s = q.poll();
				int i = Integer.parseInt(s.split(",")[0]);
				int j = Integer.parseInt(s.split(",")[1]);
				System.out.print(matrix[i][j] + " ");
				visited[i][j] = true;
				// down
				if (i + 1 < x && !visited[i + 1][j] && !q.contains((i + 1) + "," + j)) {
					q.add(new String((i+1)+","+j));
				}

				// right
				if (j + 1 < y && !visited[i][j + 1] && !q.contains(i + "," + (j + 1))) {
					q.add(new String(i+","+(j+1)));
				}
				size--;
			}
			System.out.println();
		}
	}

}
