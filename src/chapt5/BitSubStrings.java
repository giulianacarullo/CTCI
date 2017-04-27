package chapt5;
/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * 
 * Write a method to set all bits between i and j in N equal to M 
 * (e.g., M becomes a substring of N located at i and starting at j)
 * 
 * EXAMPLE:
 *    Input: N = 10000000000, M = 10101, i = 2, j = 6 
 *    Output: N = 10001010100
 *
 * @author giulianacarullo
 *
 */
public class BitSubStrings {

	public static void main(String[] args) {
		int N =23; 
		int M = 2; 
		System.out.println("N " + Integer.toBinaryString(N));
		System.out.println("M " + Integer.toBinaryString(M));
		int result = setBit(N, M, 1, 3);
		System.out.println(Integer.toBinaryString(result));
	}
	
	public static int setBit(int m, int n, int i, int j) {
		// 1’s through position j, then 0’s
		int max = ~0; /* All 1’s */
		int left= max-((1<<j)-1);
		System.out.println(" MAX "+Integer.toBinaryString(max));
		System.out.println("LEFT "+ Integer.toBinaryString( left));
		// 1’s after position i
		int right=((1<<i)-1);
		System.out.println("RIGHT "+ Integer.toBinaryString( left));
		// 1’s, with 0s between i and j
		int mask = left | right;
		System.out.println("MASK "+ Integer.toBinaryString( left));
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}
}
