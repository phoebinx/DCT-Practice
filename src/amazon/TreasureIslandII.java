package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandII {
	public static void main(String args[]) {
		char grid[][] = {{'S', 'O', 'O', 'S', 'S'},
		                 {'D', 'O', 'D', 'O', 'D'},
		                 {'O', 'O', 'O', 'O', 'X'},
		                 {'X', 'D', 'D', 'O', 'O'},
		                 {'X', 'D', 'D', 'D', 'O'}};


		TreasureIslandII obj = new TreasureIslandII();
		System.out.println(obj.diffStart(grid));
	}
	
	public int diffStart(char [][] grid) {
		int minSteps = Integer.MAX_VALUE;
		for (int i = 0;i<grid.length;i++) {
			for (int j = 0;j<grid[0].length;j++) {
				if (grid[i][j]=='S') {
					minSteps = Math.min(minSteps,minSteps(grid, i,j) );
				}
			}
		}
		return minSteps;
	}

	public int minSteps(char[][] grid, int sx, int sy) {
		if (grid == null || grid.length == 0)
			return 0;
		int steps = 0;
		int x, y;
		Queue<Integer> xQ = new LinkedList<>();
		Queue<Integer> yQ = new LinkedList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		xQ.add(sx);
		yQ.add(sy);
		visited[sx][sy] = true;
		while (!xQ.isEmpty()) {
			for (int i = 0; i < xQ.size(); i++) {
				x = xQ.poll();
				y = yQ.poll();
				if (grid[x][y] == 'X')
					return steps;
				int xNeighbors[] = { 0, 0, 1, -1 };
				int yNeighbors[] = { 1, -1, 0, 1 };
				for (int k = 0; k < 4; k++) {
					if (isSafe(x + xNeighbors[k], y + yNeighbors[k], visited, grid)) {
						visited[x + xNeighbors[k]][y + yNeighbors[k]] = true;
						xQ.add(x + xNeighbors[k]);
						yQ.add(y + yNeighbors[k]);
					}
				}
			}
			steps = steps + 1;
		}
		return 0;
	}


	public boolean isSafe(int i, int j, boolean[][] visited, char[][] grid) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !visited[i][j]
				&& (grid[i][j] == 'O' || grid[i][j] == 'X'||  grid[i][j] == 'S'))
			return true;
		return false;
	}
}
