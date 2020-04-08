package interview;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

//"4"+"4"
public class AddStringNum {
	@Test
	public void test() {
		AddStringNum obj = new AddStringNum();
		assertEquals("4", obj.sum("2", "2"));
	}

	public static void main(String args[]) {
//		AddStringNum obj = new AddStringNum();
//		String a = "";
//		String b = "";
		
	}

	public String sum(String num1, String num2) {
		int len = Math.max(num1.length(),num2.length()); 
				
		return null;
	}
}
