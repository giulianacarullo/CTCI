package chapt2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import chapt2.SumAsLinkedList.SingleLinkedList.Node;

/**
 * 
 * Given a circular linked list, implement an algorithm which returns node at the beginning 
 * of the loop.
 * 
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer 
 * points to an earlier node, so as to make a loop in the linked list.
 * 
 * EXAMPLE
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 *
 * @author giulianacarullo
 *
 */
public class BeginningOfTheLoop {

	public static void main(String[] args) {
		
		LinkedList<String> circular = new LinkedList<>();
		circular.add("A");
		circular.add("B");
		circular.add("C");
		circular.add("A");
		String result = getHead(circular);
		if (result == null)
			System.out.println("The given list is not circular");
		else
			System.out.println(result);
			
	}
	
	/**
	 * The head is the first repeated element. 
	 * @param listNodes
	 * @return
	 */
	public static String getHead(LinkedList<String> listNodes) {
		HashSet<String> nodes = new HashSet<String>();
		for (String n: listNodes)
			if (nodes.contains(n))
				return n;
			else
				nodes.add(n);
		return null;
	}
}
