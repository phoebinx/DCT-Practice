package practiceBinary;
//https://leetcode.com/problems/reverse-bits/
public class ReverseBita {
	public static void main(String args[]) {
		ReverseBita obj = new ReverseBita();
		System.out.println(obj.reverse(11));
	}
	
	public long reverse(long num) {
		long rev=0;
		 while (num>0) {
			 rev<<=1;
			 if ((num&1)==1)
				 rev^=1;//set last bit to last bit of num
			 num>>=1;//remove last bit of num
		 }
		return rev;
	}
}
//idea is simple again, rightshift num and add that to rev after leftshifting it.
//https://www.geeksforgeeks.org/reverse-actual-bits-given-number/