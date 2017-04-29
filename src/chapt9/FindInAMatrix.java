package chapt9;

/**
 * Given a matrix in which each row and each column is sorted, 
 * write a method to find an element in it.
 * 
 * Example of input:
 *  1   2   3   4 
 *  2   9  12  15
 *  7  10  13  16
 *  8  11  14  17
 * 
 * Considering a MxN matrix of integers 
 * 
 * A naive solution might be applying binary search for each row.
 * This would end up in O(M longN) => if M almost equals to N => 
 * O(N logN), which is better than classical O(MxN) that under the 
 * same assumption can be generalized as O(N^2). 
 * 
 * However, we can do better:
 * 
 * if we start from the top right (0,N) we know that:
 *     *if the element is the one we were searching for: ok found
 *     * otherwise if the searched element is less than the current inspected element
 *     * it will surely be less than other the other elements on the same column. 
 *     * thus in this case we will start searching on the previous column.
 *     
 *     * similarly, if the element is bigger than the inspected value,
 *     * it means that we have to inspect further the same column (i.e row++). 
 * 
 * @author giulianacarullo
 *
 */
public class FindInAMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2 , 3},{2, 4, 5},{3, 5, 10}
				
		};
		int el=50;
		int[] found = find(matrix, el);
		if(found == null) 
			System.out.println(el + " is not in the matrix");
		else
			System.out.println(el + "is at "+found[0] + " - "+ found[1]);
		
	}
	
	public static int[] find(int[][] matrix, int el){
		if(matrix == null || matrix.length == 0)
			return null;
		int c = matrix[0].length-1;
		int r = 0; 
		while(r <= matrix.length-1 && c>=0) {
			if(matrix[r][c] == el) {
				 int[] ret= {r, c};
				 return ret;
			}
			if(el < matrix[r][c]) //we have to move to the left
				c--;
			else
				r++;
		}
		return null;
	}
		
}
