package chapt3;

import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order. 
 * You should not make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used to write this program: 
 * push | pop | peek | isEmpty
 * 
 * @author giulianacarullo
 *
 */
public class AscendingStackSort {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(3);
		s.push(2);
		s.push(3);
		s.push(1);
		s.push(6);
		Stack<Integer> ns = ascendingSort(s);
		System.out.println(ns);
	}
	
	/**
	 * Naive version of the algorithm: use additional memory to sort
	 * the elements in the stack and then repush elements in a ordered way
	 * into the stack and return it. 
	 * 
	 * However we can use another stack for the purpose. 
	 * 
	 * Assumption: sorting integers.
	 * Observation: ascending means the minimum is on top.
	 * 
	 * The worst case is when the original stack is ordered in descending way. 
	 * In this case it takes O(N)
	 * @param stack
	 * @return the sorted stack
	 */
	public static Stack<Integer> ascendingSort(Stack<Integer> stack) {
		Stack<Integer> ns = new Stack<>();
		while(!stack.isEmpty()) {
			Integer el = stack.pop();
			while(!ns.isEmpty() && ns.peek() > el)
				stack.push(ns.pop());
			ns.push(el);
		}
		return ns;
		
	}
}
