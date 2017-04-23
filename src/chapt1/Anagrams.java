package chapt1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a method to decide if two strings are anagrams or not
 * 
 * @author giulianacarullo
 *
 */
public class Anagrams {
	public static void main(String[] args){
		String str = "aaaa";
		Set<String> testSet= new HashSet<>();
		testSet.add("aaaa");
		testSet.add("aa");
		testSet.add("ab");
		testSet.add("bbbbbbb");
		for(String s: testSet )
			System.out.println("Anagram "+ str + " - " + s +": "+anagrams(str, s) );
		
	}
	
	/**
	 * Let's suppose I can use additional memory. HashMaps! Hurray!!!
	 * 
	 * In this case I am using additional memory O(n) where n is the length of the input string
	 * Time complexity O(n)
	 * 
	 * @param str1
	 * @param str2
	 * @return true if one is the two strings are anagrams
	 */
	public static boolean anagrams(String str1, String str2){
		//checking edge cases
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() ==0)
			return false; 
		//if the two strings have different lengths I can say they surely are not
		if(str1.length() != str2.length())
			return false;
		
		HashMap<Character, Integer> anagramMap = new HashMap<Character, Integer>();
		for(int i = 0; i < str1.length(); i++){
			char cur = str1.charAt(i);
			if(anagramMap.containsKey(cur))
				anagramMap.put(cur, anagramMap.get(cur)+1);
			else
				anagramMap.put(cur, 1);
		} 
		// at the end of this iteration I do have all the chars in str1 and relative occurences
		for(int i= 0; i < str2.length(); i++){
			char cur = str2.charAt(i);
			if(anagramMap.containsKey(cur))
				anagramMap.put(cur, anagramMap.get(cur)-1);
			else
				return false;
		}
		
		return true;
	}
}
