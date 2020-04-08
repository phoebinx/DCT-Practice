package amazon;
//https://leetcode.com/discuss/interview-question/330356
public class LongestStringWithout3ConsecutiveCharacters {
	public static void main(String args[]) {
		int A = 1, B = 1, C = 6;
		LongestStringWithout3ConsecutiveCharacters obj = new LongestStringWithout3ConsecutiveCharacters();
		System.out.println(obj.getCombo(A,B,C));
	}
	
	public String getCombo(int A, int B, int C) {
		StringBuilder sb = new StringBuilder();
		while (A!=0 && B!=0 && C!=0) {
			sb.append("abc");
			A=A-1;
			B=B-1;
			C=C-1;
		}
		
		while (A!=0) {
			for (int i = 1;i<sb.length();i++) {
				if (sb.charAt(i-1)!='a' && sb.charAt(i)!='a') {
					sb.insert(i, 'a');
					A=A-1;
				} else {
					continue;
				}
			}
		}
		while (B!=0) {
			for (int i = 1;i<sb.length();i++) {
				if (sb.charAt(i-1)!='b' && sb.charAt(i)!='b') {
					sb.insert(i, 'b');
					B=B-1;
				} else {
					continue;
				}
			}
		}
		while (C!=0) {
			for (int i = 1;i<sb.length();i++) {
				if (sb.charAt(i-1)!='c' && sb.charAt(i)!='c') {
					sb.insert(i-1, "cc");
					C=C-1;
				} else if (sb.charAt(i-1)!='c' || sb.charAt(i)!='c'){
					sb.insert(i, 'c');
					C=C-1;
				} else {
					continue;
				}
			}
			break;
		}
		return sb.toString();
	}
}
