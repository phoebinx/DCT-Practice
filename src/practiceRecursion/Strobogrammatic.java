package practiceRecursion;

public class Strobogrammatic {
	public static void main(String args[]) {
		Strobogrammatic obj = new Strobogrammatic();
		System.out.println(obj.isStrobogramaatic("69"));
		
	}
	
	public boolean isStrobogramaatic(String num) {
		StringBuilder str = new StringBuilder();
		for(int i =0;i<num.length();i++) {
			str.append(getUSD(num.charAt(i)));
		}
		return num.contentEquals(str.toString());
	}

	public char getUSD(char i) {
		switch (i) {
		case '0':
			return '0';
		case '8':
			return '8';
		case '1':
			return '1';
		case '6':
			return '6';
		case '9':
			return '9';
		default:
			return '*';
		}

	}
}

//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//For example, the numbers "69", "88", and "818" are all strobogrammatic.