package practiceBinary;

public class decimalToBin {

	public static void main(String args[]) {
		int num = 27;
		decimalToBin obj = new decimalToBin();
		System.out.println(obj.toBin(num));
	}

	public String toBin(int num) {
		StringBuilder str = new StringBuilder();
		while (num / 2 > 0) {
			str.append(num % 2);
			num = num / 2;
		}
		if (num == 1)
			str.append(num);
		return str.reverse().toString();
	}

}
