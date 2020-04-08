package amazon;
//https://leetcode.com/discuss/interview-question/347457
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
	public static void main(String args[]) {
		char grid[][] = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'X', 'D', 'D', 'O' } };
		TreasureIsland obj = new TreasureIsland();
		System.out.println(obj.minSteps(grid));
	}

	public int minSteps(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int steps = 0;
		int x, y;
		Queue<Integer> xQ = new LinkedList<>();
		Queue<Integer> yQ = new LinkedList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		xQ.add(0);
		yQ.add(0);
		visited[0][0]= true;
		while (!xQ.isEmpty()) {
			int size = xQ.size();
			for (int i = 0;i<size;i++) {
				x = xQ.poll();
				y = yQ.poll();
				if (grid[x][y]=='X')
					return steps;
				int xNeighbors[] = {0,0,1,-1}; 
				int yNeighbors[] = {1,-1,0,1};
				for (int k = 0;k<4;k++) {
					if (isSafe(x+xNeighbors[k], y+yNeighbors[k], visited, grid)) {
						visited[x+xNeighbors[k]][y+yNeighbors[k]] = true;
						xQ.add(x+xNeighbors[k]);
						yQ.add(y+yNeighbors[k]);
					}
				}
			}
			steps = steps+1;
		}
		return 0;
	}

	public boolean isSafe(int i, int j, boolean [][] visited, char[][] grid) {
		if (i>=0 && j>=0 && i<grid.length && j <grid[0].length && !visited[i][j] && (grid[i][j]=='O' || grid[i][j] == 'X'))
				return true;
		return false;
	}
}
