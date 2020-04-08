package amazon;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfClusters {
	public static void main(String args[]) {
//		char [][] grid = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
		char[][] grid  = 
				{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		NumberOfClusters obj = new NumberOfClusters();
		System.out.println(obj.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length==0)
			return 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0;i<grid.length;i++) {
			for (int j = 0;j<grid[0].length;j++) {
				if (!visited[i][j] && grid[i][j]=='1') {
					traverseEntireIsland(i,j,grid, visited);
					count = count+1;
				}
			}
		}
		return count;
	}
	
	public void traverseEntireIsland(int i, int j, char[][] grid, boolean[][] visited) {
		visited[i][j] = true;
		int x[] = {-1,1,0,0};
		int y[] = {0,0,-1,1};
		for (int k = 0;k<4;k++) {
			if (isIsland(i+x[k],j+y[k],grid, visited)) 
				traverseEntireIsland(i+x[k],j+y[k], grid, visited);
		}
	}
	
	public boolean isIsland(int i,int j, char[][] grid, boolean[][] visited) {
		if (i>=0 && i<grid.length && j>=0 && j<grid[0].length && !visited[i][j] && grid[i][j]=='1')
			return true;
		return false;
	}
}
