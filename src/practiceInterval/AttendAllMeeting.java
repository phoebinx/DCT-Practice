package practiceInterval;

import java.util.Arrays;
import java.util.Stack;

//http://tiancao.me/Leetcode-Unlocked/LeetCode%20Locked/c1.6.html
public class AttendAllMeeting {
	int [][] matrix = {{0,3}, {5,10}, {15,20}};
	
	
	public static void main(String args[]) {
		AttendAllMeeting obj = new AttendAllMeeting();
		Arrays.sort(obj.matrix,
				(int [] a, int b[])->{
					return a[0]-b[0];
				});
		System.out.println(obj.canAttendAllMeetings());
		
	}
	
	public boolean canAttendAllMeetings() {
		Stack< int []> stack = new Stack<>();
		stack.push(matrix[0]);
		for (int i = 1; i<matrix.length;i++) {
			int [] a = stack.peek();
			int []b = matrix[i];
			//if overlapping, not able to attend 
			if (a[0]<b[1] && b[0]<a[1])
				return false;
			stack.push(matrix[i]);
		}
		return true;
	}
	
	
}
