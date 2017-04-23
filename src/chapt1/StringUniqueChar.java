package chapt1;
/**
 * Ex1.1: Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * 
 * @author giulianacarullo
 *
 */
public class StringUniqueChar {
	public static void main(String[] args){
		/**adding a bit of testing here (unique) **/
		System.out.println("Testing unique()");
		String uniqueString = "abcdefg";
		String notUnique = "abcdefa";
		System.out.println("uniqueString is unique:"+unique(uniqueString));
		System.out.println("notUnique is unique:"+unique(notUnique));
		//testing edge cases
		System.out.println("null string is unique:"+unique(null));
		System.out.println("empty string is unique"+unique(""));
		
		/**adding a bit of testing here (unique2) **/
		System.out.println("Testing unique2()");
		System.out.println("uniqueString is unique:"+unique2(uniqueString));
		System.out.println("notUnique is unique:"+unique2(notUnique));
		//testing edge cases
		System.out.println("null string is unique:"+unique2(null));
		System.out.println("empty string is unique"+unique2(""));
	}
	
	/* 
	 * 
	 * If no data structure can be used (I am sad, I want to use hashmaps :( )
	 * a simple solution could be to check char by char (i from 0 to n) 
	 * if it is equals to any of the subsequent elements in the string.
	 * As soon as a repetition is found, non uniqueness is signalled (retun false).
	 * 
	 * This way we will end up with O(1) space complexity (no additional memory)
	 * and O(n^2) time complexity (give me my hashmap!!!)
	 * 
	 * Edge cases considered:
	 * 1) empty string. => suppose false
	 * 2) null string => suppose false
	 * 3) very long string?! eheheheh
	 */
	public static boolean unique(String string){
		//check edge case
		if(string == null || string == "")
			return false;
		
		for(int i = 0; i<string.length()-1; i++){
			char current = string.charAt(i);
			for (int j = i+1; j < string.length(); j++){
				if (current == string.charAt(j))
					return false;
			}
		}
		return true;
	}
	/*
	 * Can we do better? Yes! 
	 * For simplicity, assume char set is ASCII (if not, we need to increase 
	 * the storage size. The rest of the logic would be the same)
	 * 
	 * time complexity: O(n) where n is the length of the string
	 * space complexity: O(n) --
	 */
	public static boolean unique2(String string){
		//check edge case
		if(string == null || string == "")
			return false;
		
		boolean[] charset = new boolean[256];
		for (int i = 0; i< string.length(); i++){
			int value = string.charAt(i);
			System.out.println("value:" + value);
			if(charset[value])
				return false;
			charset[value] = true;
		}
		return true;
	}
	
	/*
	 * We could do even better in terms of space 
	 */

}
