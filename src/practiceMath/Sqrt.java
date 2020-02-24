package practiceMath;

//https://leetcode.com/problems/sqrtx/
public class Sqrt {
	public static void main(String args[]) {
		Sqrt obj = new Sqrt();
		int x = 2147483647;
		//int x =10000;
		System.out.println(obj.mySqrt(x));
	}

    public int mySqrt(int x) {
        int numPlaces = (Integer.toString(x).length() - 1);
        int numZero = numPlaces / 2;
        long i = 1;
        if (numZero >= 1)
			i = (int) Math.pow(10,numZero);
        while(i*i <x) 
			i = i+1;
		if (i*i == x)
			return (int)i;
		return (int)(i-1);   
    }
}

//Geting maximum number after which sq root can be found,
//if x is 2 sigit, num = 1, if x = 3 digit, num = 10, 
//if x = 5 digit, num is 100
