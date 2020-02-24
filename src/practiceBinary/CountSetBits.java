package practiceBinary;
//brian karnighan's algorithm
public class CountSetBits {
	public static void main(String args[]) {
		int i = 7, setBits=0;
		
		
		while (i>0) {
			i=i&(i-1); //i-1 unsets the last bit, & with i undo the toggle that happens to other digits.
			setBits++;
		}
		System.out.println(setBits);
	}
}
