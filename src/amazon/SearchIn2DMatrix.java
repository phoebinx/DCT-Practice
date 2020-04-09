package amazon;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchIn2DMatrix {
	public static void main(String args[]) {
		SearchIn2DMatrix obj = new SearchIn2DMatrix();
		int matrix2[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 20;
		System.out.println(obj.searchMatrixII(matrix2, target));
		int matrix1[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		target = 20;
		System.out.println(obj.searchMatrix(matrix1, target));
	}

	public boolean searchMatrixII(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int curRow = 0;
		int curCol = matrix[0].length - 1;

		while (curRow < matrix.length && curCol >= 0) {
			if (matrix[curRow][curCol] == target)
				return true;
			else if (matrix[curRow][curCol] > target)
				curCol = curCol - 1;
			else
				curRow = curRow + 1;
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length==0) return false;
		int rows = matrix.length;
		int cols=  matrix[0].length;
		
		//consider 2d matrix to be a linear array
		int left = 0;
		int right = rows * (cols-1);
		
		while (left<=right) {
			int mid = left+ (right-left)/2;
			int midElement = matrix[mid/cols][mid%cols];
			if (midElement == target) return true;
			else if (midElement> target) right=mid-1;
			else if (midElement<target) left=mid+1;
		}
		return false;
	}
}
