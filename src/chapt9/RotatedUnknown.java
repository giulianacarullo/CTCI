package chapt9;
/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, 
 * give an O(logn) algorithm that finds an element in the array. 
 * 
 * You may assume that the array was originally sorted in increasing order
 * EXAMPLE:
 *    Input:  find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14) 
 *    Output: 8 (the index of 5 in the array)
 *    
 * @author giulianacarullo
 *
 */
public class RotatedUnknown {
	public static void main(String[] args) {
		int[] a = {15, 16, 19,20, 25, 1, 3, 4, 5, 7, 10,14};
		System.out.println("Index of 5: " + find(a, 5));
		System.out.println("Index of 7: " + find(a, 7));
		System.out.println("Index of 15: " + find(a, 15));
		System.out.println("Index of 16: " + find(a, 16));
		System.out.println("Index of 50: " + find(a, 50));
		int [] b = {2,2,2,2,2};
		System.out.println("Index of 2: " + find(b, 2));
		int [] c = {2,2,2,3,2,2};
		System.out.println("Index of 3: " + find(c, 3));
	}
	/**
	 * The idea here is have a slightly modified binary search: 
	 *    * pick the middle element
	 *    * if the searched element is in between pick and last search right
	 *    * otherwise search left.
	 *    
	 * @param array
	 * @param el
	 * @return
	 */
	public static int find(int[] array, int el) {
		if(array== null || array.length == 0)
			return -1;
		else
			return find(array, el, 0, array.length-1);
	}
	/**
	 * In case of duplicates, it just returns the first element found.
	 * The code is not able to deal with  cases like {2,2,2,3,2,2}
	 */
	private static int find(int[] array, int el, int start, int end ){
		int middle = (start+end)/2;
		//base case: element found
		if(array[middle] == el)
			return middle;
		while(start<=end) {
			//System.out.println("searching "+start + " - "+ end);
			if(el>=array[middle] && el <= array[end]) {
				return find(array, el, middle+1, end);
			}
			else
				return find(array, el,start, middle-1);
		}
		return -1;
	}
}
