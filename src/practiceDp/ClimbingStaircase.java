package practiceDp;
//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStaircase {
	
	int arr[];
	int n;
	public static void main(String args[]) {
		ClimbingStaircase obj = new ClimbingStaircase();
		obj.arr = new int[] {1,2,3};
		obj.n = 4;
		System.out.println(obj.totalWays());
	}
	
	public int totalWays() {
		int out[] = new int[this.n+1];
		out[0]=1;
		for (int i = 1;i<=n;i++) {
			for (int j:arr) {
				if (i-j>=0)
					out[i] = out[i-j] + out[i];
			}
		}
		return out[n];
	}
}
