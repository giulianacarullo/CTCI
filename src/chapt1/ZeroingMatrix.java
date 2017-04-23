package chapt1;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0.
 * 
 * @author giulianacarullo
 *
 */
public class ZeroingMatrix {
	public static void main(String[] args){
	int [][] inMatrix = {
			{1, 1, 1, 0}, 
			{0, 1, 1, 0},
			{1, 1, 1, 1},
			{1, 1, 1, 1}
			
	};
	zero(inMatrix);
	
	}
	
	/**
	 * The naive idea could be to check the matrix and every time we encounter a zero,
	 * we zeroes both row and column. However, it would require going through a row and
	 * a column two times. 
	 * 
	 * The idea behinde the codes solution is to scan first for zeros, store the 
	 * associated row and column and the to reset them. 
	 * 
	 * Supposing it is a matrix of integers. 
	 * 
	 * @param matrix
	 */
	public static void zero(int[][] matrix){
		//check edges
		if(matrix == null || matrix.length==0)
			return;
		
		Set<Integer> zeroRows = new LinkedHashSet<Integer>();
		Set<Integer> zeroCols = new LinkedHashSet<Integer>();
		printMatrix(matrix);
		System.out.println("Result");
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i< rows; i++) {
			for(int j = 0; j< cols; j++){
				if(matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
					
			}
		}
		
		// I can now now reset the necessary rows and columns
		for(Integer r: zeroRows) 
			for (int j = 0; j < cols; j++ )
				matrix[r][j] = 0;
		
		for(Integer c: zeroCols) 
			for (int i = 0; i < rows; i++ )
				matrix[i][c] = 0;
		printMatrix(matrix);
	}
	
	//for test purposes
	private static void printMatrix(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for (int i = 0; i< rows; i++){
			for (int j = 0; j < cols; j++) 
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
			
	}
}
