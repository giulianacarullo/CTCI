package chapt1;

import java.util.HashSet;
import java.util.Set;

/**
 * Replace all spaces in a string with '%20'.
 * Time complexity O(n) where n is the size of the input string
 * @author giulianacarullo
 *
 */
public class ReplaceSpaces {
	public static void main(String[] args){
		Set<String> testSet = new HashSet<>();
		testSet.add("aaaa");
		testSet.add("a a a");
		testSet.add(" a ");
		testSet.add("     "); //only 5 spaces
		for (String s: testSet)
			replaceSpace(s.toCharArray());
	}
	
	/**
	 * Avoiding simply using regexpr in Java, because changes in strings 
	 * are expensive (performance). 
	 * 
	 * The idea is to first count the occurrences of space in the string, 
	 * realloc more memory (new char array) and then do the substitution on the new array.
	 * 
	 * @param inString
	 */
	public static void replaceSpace(char[] inString){
		System.out.print("String " + new String(inString));
		int counter = 0;
		for(int i = 0; i < inString.length; i++) 
			if(inString[i] == ' ' )
				counter++;
		
		if(counter == 0) {
			System.out.println(" - replace: " + new String(inString));
			return;
		}
			
		int newSize = inString.length + 2*counter; //one char from space + 2
		char[] repString = new char[newSize];
		int j = newSize-1;
		for(int i = inString.length-1; i>=0; i--) {
			if(inString[i] != ' ') {
				repString[j] = inString[i];
				j--;
			}
			else {
				repString[j] = '0';
				repString[--j] = '2';
				repString[--j] = '%';
				j--;
			}
		}
		System.out.println(" - replace: " + new String(repString));
		
	}

}
