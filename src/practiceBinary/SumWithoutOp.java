package practiceBinary;
//https://leetcode.com/problems/sum-of-two-integers
public class SumWithoutOp {
	public static void main(String args[]) {
		SumWithoutOp obj = new SumWithoutOp();
		int x=5;
		int y=3;
		System.out.println((obj.add(x,y)));
	}
	
	public int add(int x, int y) {
		int result;
		//int bOrC;
		while(x>0) {
			result = x^y;
			if (x<0 || y<0)
				y = ~(x&y);
			y= (x&y)<<1;//carry left shifted by 1
			x=result;
		}
		return y;
	}
}
