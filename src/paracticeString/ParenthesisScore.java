package paracticeString;

import java.util.HashMap;
import java.util.Stack;
//https://www.youtube.com/watch?v=jfmJusJ0qKM
//https://leetcode.com/problems/score-of-parentheses/
public class ParenthesisScore {
	class Bracket {
		Character c;
		int nestLevel;
		int n1 = 0;
		int n2 = 0;

		Bracket(Character c, int nestLevel) {
			this.c = c;
			this.nestLevel = nestLevel;
		}
	}

	public static void main(String args[]) {
		ParenthesisScore obj = new ParenthesisScore();
		String input = "(()(()))";
		System.out.println(obj.score(input));
	}

	public int score(String str) {
		int score = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(score);
				score = 0;
			} else {
				score = stack.pop() + Math.max(score*2, 1);
			}
		}
		return score;
	}
}
//score is calculated while poping and when you push m you always push the previous or up till now score
//