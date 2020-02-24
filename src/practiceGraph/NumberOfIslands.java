package practiceGraph;
//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
	int [][] matrix;
	
	public static void main(String args[]) {
		NumberOfIslands obj = new NumberOfIslands();
		//int matrix [][] = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
		int matrix [][] = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		obj.matrix= matrix;
		System.out.println(obj.countIslands());
	}
	
	public int countIslands() {
		if (matrix.length==0)
			return 0;
		
		int count = 0;
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		
		for (int i = 0; i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
				if (i==2 && j==2) {
					System.out.println("hi");
				}
				if (!visited[i][j] && matrix[i][j]==1) {
					dfs(i,j,visited);
					count++;
				}
			}
		}
		return count;
	}
	
	public void dfs(int i, int j , boolean visited[][]) {
		visited[i][j] = true;
		//no diagonal, only up down right and left
		int x[]= {0,0,-1,1};
		int y[]= {-1,1,0,0};
		
		for (int k = 0;k<4;k++) {
			if (isSafe(i+x[k],j+y[k], visited)) {
				dfs(i+x[k], j+y[k], visited);
			}
		}
	}
	
	public boolean isSafe(int i, int j, boolean visited[][]) {
		if (i<matrix.length && i>=0 && j<matrix[0].length && j>=0 && matrix[i][j]==1 && !visited[i][j]) {
			return true;
		}
		return false;
	}
	

}
