package practiceDp;

public class DecodeWays {
	String str = "2237";
	public static void main(String args[]) {
		DecodeWays obj = new DecodeWays();
		System.out.println(obj.decode(obj.str));
	}
	
	public int decode(String str) {
		if (str.length()==0)
			return 1;
		if (str.substring(0,1)=="0")
			return 0;
		
		int count = 0,num = 0;
		
		if (str.length()>1) {
			num = Integer.parseInt(str.substring(0,2));
			if (num<=26)
				count = count+ decode(str.substring(2,str.length()));
		}
		count = count+decode(str.substring(1,str.length()));
				
		return count;
	}
	
}
