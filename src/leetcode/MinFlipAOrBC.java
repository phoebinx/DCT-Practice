package leetcode;

//https://leetcode.com/contest/weekly-contest-171/problems/minimum-flips-to-make-a-or-b-equal-to-c/
public class MinFlipAOrBC {
	public static void main(String args[]) {
		MinFlipAOrBC obj = new MinFlipAOrBC();
		System.out.println(obj.minFlips(1, 2, 3));
		// System.out.println((6 & (1<<1))!=0);
	}

	public int minFlips(int a, int b, int c) {
		int count = 0;
		boolean x, y, z;
		for (int i = 0; i < 31; i++) {
			x = ((a & (1 << i)) != 0);
			y = ((b & (1 << i)) != 0);
			z = ((c & (1 << i)) != 0);

			if ((x | y) == z) {
				continue;
			}

			if (x == y) {
				if (z == true)
					count = count + 1;
				else
					count = count + 2;
			} else {
				count = count + 1;
			}

		}
		return count;
	}
}
