package practiceDp;
//https://leetcode.com/problems/jump-game/
public class JumpGame {
	int arr[]= {2,3,1,1,0};
	public static void main(String args[]) {
		JumpGame obj = new JumpGame();
		System.out.println(obj.reachEnd(0));
	}
	
	public boolean reachEnd( int i) {
		if (i==arr.length-1)
			return true;
		if (i>arr.length-1 || arr[i]==0)
			return false;
		return reachEnd(i+arr[i]);
	}
}
