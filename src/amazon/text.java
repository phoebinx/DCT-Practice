package amazon;

import java.util.Arrays;
import java.util.List;

public class text {
	public static void main(String args[]) {
		int states []= {1,1,1,0,1,1,1,1};
		int days = 3;
		text obj = new  text();
		System.out.println(obj.cellCompete(states, days));
	}
	
	public List<Integer> cellCompete(int[] states, int days)
	    {
	        int curDay[] = states;
	        int nextDay[] = new int[states.length];
	        int count = days;
	        int prev=0,next=0;
	        while (count>0) {
	            for (int i = 0;i<states.length;i++) {
	                if (i==0) prev = 0;
	                else prev = curDay[i-1];  
	                if (i == states.length-1) next = 0;
	                else next = curDay[i+1];
	                
	                if (prev == next) nextDay[i] = 0;
	                else nextDay[i] = 1;
	            }
	            count = count-1;
	            curDay = nextDay.clone();
	        }
	        Integer [] res =  Arrays.stream(curDay).boxed().toArray(Integer[]::new);
	        return Arrays.asList(res);
	    }
}
