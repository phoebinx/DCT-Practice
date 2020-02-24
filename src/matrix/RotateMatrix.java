package matrix;

//https://leetcode.com/problems/rotate-image/
//https://www.youtube.com/watch?v=SA867FvqHrM
//First transpose the matrix then swap the columns as the first column becomes the last.

public class RotateMatrix {
	public static void main(String args[]) {
		RotateMatrix obj = new RotateMatrix();
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		obj.rotate(matrix);
		for (int k[]: matrix) {
			for(int l:k) {
				System.out.print(l);
			}
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		if (matrix.length==0 || matrix.length != matrix[0].length) 
			return;
		
		transpose(matrix);
		int len = matrix.length-1;
		int temp;
		for (int i = 0;i<matrix.length;i++) {
			for (int j = 0;j < (matrix.length)/2; j++) {
				temp =matrix[i][j];
				matrix[i][j] = matrix[i][len-j];
				matrix[i][len-j] = temp;
			}
		}
	}
	
	public void transpose(int[][] matrix) {
		//set row to columns
		int temp;
		for (int i = 0; i<matrix.length;i++) {
			for (int j = i; j<matrix.length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
