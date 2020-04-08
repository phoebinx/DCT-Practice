package paracticeString;

import java.util.Stack;

//https://leetcode.com/problems/validate-stack-sequences/

public class ValidateStackSequence {
	public static void main(String argsp[]) {
		ValidateStackSequence obj = new ValidateStackSequence();
//		int [] pushed = {2,1,0};
//		int [] popped = {1,2,0};
//		int [] pushed = {1,2,3,4,5};
//		int [] popped = {4,5,3,2,1};
		int [] pushed = {1,2,3,4,5};
		int [] popped = {4,3,5,1,2};
		System.out.println(obj.validateStackSequences(pushed, popped));
	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if (pushed.length!=popped.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for (int i = 0;i<pushed.length;i++) {
			if (pushed[i]!=popped[j]) {
				stack.push(pushed[i]);
			} else {
				j = j+1;
				while (j<popped.length && !stack.isEmpty() && stack.peek()==popped[j]) {
					j = j+1;
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			if (stack.pop()!=popped[j]) {
				return false;
			}
			j=j+1;
		}
		return true;
	}
}
