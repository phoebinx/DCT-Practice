package amazon;

public class SearchIn2DMatrix {
	public static void main(String args[]) {
		SearchIn2DMatrix obj = new SearchIn2DMatrix();
		int matrix[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 20;
		System.out.println(obj.searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix==null || matrix.length==0 || matrix[0].length==0)
			return false;
		
		int curRow = 0;
		int curCol = matrix[0].length-1;
		
		while(curRow<matrix.length && curCol>=0) {
			if (matrix[curRow][curCol] == target)
				return true;
			else if (matrix[curRow][curCol] > target)
				curCol = curCol-1;
			else 
				curRow=curRow+1;
		}
		return false;
	}
}
