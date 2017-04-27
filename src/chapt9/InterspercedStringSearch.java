package chapt9;
/**
 * Given a sorted array of strings which is interspersed with empty strings, 
 * write a method to find the location of a given string.
 * 
 * Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] 
 * will return 4 
 * 
 * Example:  find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] 
 * will return -1
 * 
 * @author giulianacarullo
 *
 */
public class InterspercedStringSearch {
	public static void main(String[] args){
		String[] s = {"at", "","","","","ball", "car", "","","dad","",""};
		System.out.println("Index of ball - " + search(s, "ball"));
		System.out.println("Index of ballcar - " + search(s, "ballcar"));
		System.out.println("Index of dad - " + search(s, "dad"));
		System.out.println("Index of at - " + search(s, "at"));
	}
	
	public static int search(String[] a, String val) {
		if(a == null || a.length == 0)
			return -1;
		return search(a,val, 0, a.length-1);
	}
	private static int search(String[] a, String val, int start, int end) {
		int middle = (start+end)/2;
		int middleOriginal = middle;
		if(a[middle].compareTo(val) == 0) 
			return middle;
		while(start<=end) {
			while(a[middle] == "" && middle<=end) 
				middle++;
			if(middle == end) 
				search(a, val, start, middleOriginal-1);
			else if(val.compareTo(a[middle])>0) 
				return search(a, val, middle+1, end);
			else if(val.compareTo(a[middle]) == 0)
				return middle;
			else
				return search(a, val, start, middleOriginal-1);
			
		}
		
		return -1;
	}
	
}
