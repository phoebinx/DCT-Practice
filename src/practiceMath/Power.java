package practiceMath;

import java.util.HashMap;

//https://leetcode.com/problems/powx-n/
public class Power {
	public static void main(String argsp[]) {
		Power obj = new Power();
//		double x = 0.00001;
//		int n = 2147483647;
		double x = 2.00000;
		int n = -2147483648;
//		double x = 2.00000;
//		int n = -2;

//		double x = 2.00000;
//		int n = 10;
		double res = obj.myPow(x, n);
		System.out.println(res);
	}

	public double myPow(double x, int n) {
		/* Edge and Special cases */
		/* 1 raise to n */
		if (Math.abs(x) == 1.0) {
			return n % 2 == 0 ? Math.abs(x) : x;
		}

		/* Overflow */
//	        if (n == Integer.MIN_VALUE) { 
//	        	System.out.println();
//	        	return 0.0 ;
//	        }
//	        
		if (n == 0) {
			return 1.0;
		} else if (n < 0) {
			System.out.println();
			return 1.0 / myPow(x, -n);
		} else if (n % 2 != 0) {
			return x * myPow(x, n - 1);
		} else
			return myPow(x * x, n / 2);
	}

//	public double computePow(double x, int n) {
//		double res;
//		res = computePowRec(x, Math.abs(n));
//		if (n < 0)
//			res = 1 / res;
//		return res;
//	}
//	
//	public double computePowRec(double x, int n) {
//		double res;
//		/* Edge and Special cases */
//        /* 1 raise to n */
//        if (Math.abs(x) == 1.0) return n % 2 == 0 ? Math.abs(x) : x;
//       
//		if (n == 0)
//			return 1;
//		if (n == Integer.MIN_VALUE) return 0.0;
//		
//		
//		res = computePowRec(x, n / 2);
//		
//		if (n % 2 == 0) { // even
//			res = res * res;
//		} else {
//			res = x*res*res;
//		}
//		return res;
//	}

}

//if n if even x^n = x^n/2 * x^n/2
//if n is odd -> x^n = x^n-1

//-2147483648 *1  = 2147483648 which is more than int range so it goes back to -2147483648 and keeps never ending loop