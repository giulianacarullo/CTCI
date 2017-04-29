package chapt8;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string.
 * 
 * @author giulianacarullo
 *
 */
public class StringPermutation {

	
	static ArrayList<String> perms = new ArrayList<>(); //used to store perms over time
	public static void main(String[] args){
		String str = "abc";
		permutations(str);
		for(String s: perms)
			System.out.print(s + " - ");
		System.out.println();
	}
	
	public static void permutations(String string) {
		perm("",string);
	}
	/**
	 * This code adds to the arraylist all of the permutations of a string,
	 * given the assumption that the string is made up of unique characters.
	 * 
	 * Indeed, we consider permutation w/o repetition where:
	 *    * each string has the same length of the original string;
	 *    * the strings differs only in the ordering of characters. 
	 *    
	 * The idea is pretty simple: 
	 *   for each character in the string: 
	 *     consider the current character at position i (0,...n)
	 *     for each element compute the permutation obtained by adding the current char
	 *     to the prefix and as the remaining string (w/o current char) as the remaining 
	 *     part of the string. Stop when all the chars have been added to the prefix, we 
	 *     found a permutation.
	 *     
	 *     Example: abc:
	 *     first step: prefix = a - remaining bc
	 *       *recursion 0: prefix a - rem bc 
	 *        * loop - prefix ab - rem c
	 *        * recursion 1: prefix ab - rem c
	 *        * loop - prefix abc - rem "" => rec => base case => add abc
	 *       
	 *      second step: prefix ac - rem b
	 *        * rec 0: prefix ac - rem b
	 *        * loop: prefix acb - rem "" => rec => base case => add abc
	 *        
	 *      third step of the loop: prefix = b - remaining ac
	 *       * recursion 0: prefix b - rem ac
	 *       * loop - prefix ba - rem c
	 *       * recursion 1: prefix ba - rem c 
	 *       * loop: prefix bac - rem "" => rec => base case => add bac
	 * @param prefix
	 * @param remaining
	 */
	private static void perm(String prefix, String remaining) {
		int n = remaining.length();
		if(n == 0)
			perms.add(prefix);
		else
			for(int i = 0; i<n; i++)
				perm(prefix+ remaining.charAt(i), 
						remaining.substring(0, i) + remaining.substring(i+1, n));
	}
	
}
