package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/538068/
public class BattleShip {
	public static void main(String args[]) {
		BattleShip obj = new BattleShip();
		int N = 4;
		String S = "1B 2C,2D 4D";
		String T = "2B 2D 3D 4D 4A";
		System.out.println(obj.solution(N, S, T));
	}

	public String solution(int N, String S, String T) {
		String[] targets = T.split(" ");
		String [] ships = S.split(",");
		int hits = 0, sink=0;
		HashSet<String> shipSet = new HashSet<>();
		HashSet<String> targetSet = new HashSet<>(Arrays.asList(targets));
		
		for (String ship:ships) {
			shipSet.clear();
			String boundaries[] = ship.split(" ");
			char rowStart = boundaries[0].charAt(0);
			char rowEnd = boundaries[1].charAt(0);
			char colStart = boundaries[0].charAt(1);
			char colEnd = boundaries[1].charAt(1);
			for (char i = rowStart;i<=rowEnd;i++) {
				for (char j = colStart;j<=colEnd;j++) {
					shipSet.add(""+i+j);
				}
			}
			if (targetSet.containsAll(shipSet)) {
				sink = sink+1;
			} else {
				for (String shipPart:shipSet) {
					if (targetSet.contains(shipPart)) {
						hits = hits+1;
						break;
					}
				}
			}
		}
		
 		return ""+sink+","+hits;
	}
	
	
}
