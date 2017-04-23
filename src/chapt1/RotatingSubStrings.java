package chapt1;
/**
 * Assume you have a method isSubstring which checks if one word is a substring 
 * of another. Given two strings, s1 and s2, write code to check if s2 is a 
 * rotation of s1 using only one call to isSubstring (i.e. , "waterbottle" is a 
 * rotation of "erbottlewat")
 * 
 * @author giulianacarullo
 *
 */
public class RotatingSubStrings {
	public static void main(String[] args){
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		String s3 = "erbottlewal";
		System.out.println(isRotation(s1, s2));
		System.out.println(isRotation(s1, s3));
	}
	/**
	 * The idea is to check if the concatenation of the same 
	 * 'supposed' rotated word with itself would lead to having the original string
	 * as substring within it. 
	 * 
	 * @param s1 the word
	 * @param s2 the assumed rotation
	 * @return
	 */
	public static boolean isRotation(String s1, String s2){
		//Edge cases 
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return false;
		if(s1.length() != s2.length())
			return false;
		String conc = s2.concat(s2);
		if (isSubstring(conc, s1))
			return true;
		return false;
	}
	
	//Stub for substring 
	private static boolean isSubstring(String str1, String str2){
		return str1.contains(str2);
	}
}
