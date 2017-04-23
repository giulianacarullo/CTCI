package chapt1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Design an algorithm and write code to remove the duplicate characters in a 
 * string without using any additional buffer. 
 * 
 * NOTE: One or two additional variables are fine. 
 * An extra copy of the array is not.
 * 
 * FOLLOW UP
 * Write the test cases for this method
 * @author giulianacarullo
 *
 */
public class DuplicateCharsString {
	//test
	public static void main(String[]args){
		//Testing here
		Set<String> testSet= new HashSet<>();
		testSet.add("abcde");
		testSet.add("abacde");
		testSet.add("aaabbb");
		testSet.add("aaa");
		testSet.add("ababa");
		
		//testing first version
		for(String in: testSet)
			removeDuplicate(in.toCharArray());
			
		//testing third version
		for(String in: testSet)
			removeDuplicate3(in.toCharArray());
		
	}
	
	/**
	 * Since no additional buffer can be used (ouch not hashmaps agains!) 
	 * The naive method is to proceed as we did in StringUniqueChar and instead of just 
	 * checking we are going to remove it as well. 
	 * 
	 * The idea for the removal here is to overwrite the duplicate char with the next chars 
	 * from the string and padding with 'empty' chars.
	 * However, this algorithm has really baaaad performance! 
	 * 
	 * @param inString
	 * @return
	 */
	public static void removeDuplicate(char[] inString){
		//checking for invalid input
		if(inString == null || inString.length == 0)
			return;
		if(inString.length == 1) {
			System.out.println(new String(inString));
			return;
		}
		
		System.out.print ("Trimming "+ new String(inString) + " from duplicates"); //just for testing purposes
		int tail = inString.length;
		for(int i = 0; i < tail-1; i++){
			char currentChar = inString[i];
			for (int j = i+1; j < tail; j++){
				if(currentChar == inString[j]){
					for(int k = j; k < tail-1 ; k++) 
						inString[k] = inString[k+1];
					inString[tail-1] = ' ';
					tail--;
					j--;
				}
			}
		}
		System.out.println(" - Result: " + new String(inString));
	}
	
	
	/**
	 * If I could use a LinkedHashSet (i.e. additional memory).
	 * Observe that a LHS also preserve the ordering of chars.
	 */
	public static void removeDuplicate3(char[] inString){
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (char c : inString) 
		    charSet.add(c);
		StringBuilder sb = new StringBuilder();
		for (Character character : charSet) 
		    sb.append(character);
		
		System.out.println(sb.toString());
	}
}

