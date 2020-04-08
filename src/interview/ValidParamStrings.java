package interview;

public class ValidParamStrings {
	public static void main(String args[]) {
		ValidParamStrings obj = new ValidParamStrings();
		int count = 4;
		//obj.validParen(new String(), count,0,0);
		
		int n = 3;
		
		obj.generate(n);

	}

	public void validParen(String str, int count, int openCount, int closeCount) {
		if (str.length()==count*2) {
			System.out.println(str);
			return;
		}
		if (openCount<count && canAddOpen(str,count)) {
			validParen(str+'(',count,openCount+1,closeCount);
		}
		if (closeCount<count && canAddClose(str,count,openCount,closeCount)) {
			validParen(str+')',count,openCount,closeCount+1);
		}
	}

	public boolean canAddOpen(String str, int count) {
		if (str.length()-1==count*2)
			return false;
		return true;
	}

	public boolean canAddClose(String str, int count, int openCount,int closeCount) {
		if (openCount>closeCount) {
			return true;
		}
		return false;
	}
	
	public boolean canOpen(int roc) { return roc > 0; }
	public boolean canClose(int roc, int rcc) {return roc < rcc && rcc > 0; }
	
	private void genPar(int n, String acc, int roc, int rcc) {
		if (acc.length() == n*2) { System.out.println(acc); return; }
		
		if(canOpen(roc)) { genPar(n, acc + "(", roc-1, rcc); }
		if(canClose(roc, rcc)) { genPar(n, acc + ")", roc, rcc-1); }
	}
	
	public void generate(int n) { genPar(n, "", n, n); }
}
