package chapt9;
/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer
 *  at the end to hold B.  
 *  
 *  Write a method to merge B into A in sorted order
 * 
 * @author giulianacarullo
 *
 */
public class MergeSorted {
	public static void main(String[] args) {
		
	}
	
	/**
	 * Assumption: both a and b are both ordered the same way. Let's assume increasing order
	 * and let's also assume that a and b are made up of integers. 
	 * 
	 * The idea is to start from 0 (i = 0) until we merged the entire array b (b.length).
	 * If j is the current pointer to the elements in a:
	 * 
	 * if a[j] < b[i] => j++ 
	 * otherwise add a space and insert b[i]. 
	 * 
	 * Complexity: 
	 * 	  * given N = |a| M = |b|
	 *    * in the worst case: for each element in a, it is required a shift.
	 *    
	 * Further scoping the problem: can we suppose that |a| = |a| + |b|?
	 * If yes (w/o any padding) we can do better than the previous solution
	 * by starting from the right and adding from time to time, the maximum between |a|and |b|
	 * which has not been inserted yet.
	 * This solution will require O(N+M)
	 * 
	 * @param a
	 * @param b
	 * @param n - the real number of elements in a
	 * @param m - the real number of elements in b
	 * @return
	 */
	
	public static int[] merge(int[] a, int[] b, int n, int m) {
		int j = m;
		int k = m + n + 1; //were the max of both arrays should go
		int i = n;
		while(j>0 && i>0) {
			if(b[j] > a[i]) {
				a[k] = b[j];
				j--;
			}
			else {
				a[k] = a[i];
				i--;
			}
			k--;
		}
		/*At this point, it may happen that:
		 * a still has some element to be visited, however, in this case
		 * they are exactly were they need to be.
		 * example: merging a = 1 2 4 and b = 3 
		 * 
		 * More computation is required in case we visited all the elements in a,
		 * but not all those in b. In this case, we need to copy them in a. 
		 * example:  a = 4 5 6 and b = 1 2 3 7 8
		 */
		while(j>=0) {
			a[k] = b[j];
			k--;
			j--;
		}
		
		return a;
	}
}
