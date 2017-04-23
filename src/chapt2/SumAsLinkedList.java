package chapt2;

import chapt2.NthToLast.SingleLinkedList;
import chapt2.NthToLast.SingleLinkedList.Node;

/**
 * You have two numbers represented by a linked list, where each node contains a 
 * single digit The digits are stored in reverse order, such that the 1’s digit 
 * is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list. 
 * 
 * EXAMPLE
 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * 
 * @author giulianacarullo
 *
 */
public class SumAsLinkedList {
	public static void main(String[] args){
		SingleLinkedList<Integer> ll1 = new SingleLinkedList<>();
		SingleLinkedList<Integer> ll2 = new SingleLinkedList<>();
		ll1.appendNode(3);
		ll1.appendNode(1);
		ll1.appendNode(5);
		ll2.appendNode(5);
		ll2.appendNode(9);	
		ll2.appendNode(2);
		
		System.out.println(sum(ll1,ll2));
		
		//testing a bit more
		SingleLinkedList<Integer> ll3 = new SingleLinkedList<>();
		SingleLinkedList<Integer> ll4 = new SingleLinkedList<>();
		ll3.appendNode(9);
		ll3.appendNode(9);
		ll3.appendNode(9);
		ll4.appendNode(1);
		ll4.appendNode(1);	
		ll4.appendNode(1);
		System.out.println(sum(ll3,ll4));
	}
	/**
	 * Assuming that the LLs have the same number of elements. 
	 * 
	 * The idea is to sum digits from both LLs one at the time and use an extra variable
	 * for storing excess to be used by the following digit. 
	 * 
	 * This solution takes O(N^2) because of the getElement() implementation
	 * 
	 * @param ll1
	 * @param ll2
	 * @return
	 */
	public static SingleLinkedList<Integer> sum(SingleLinkedList<Integer> ll1, 
												SingleLinkedList<Integer> ll2){
		//testing input
		if(ll1 == null || ll2 == null)
			return null;
		if(ll1.size != ll2.size)
			return null;
		int extrasum = 0;
		SingleLinkedList<Integer> outSum = new SingleLinkedList<>();
		for (int i = 0; i< ll1.size; i++) {
			Integer first = ll1.getElement(i);
			Integer second = ll2.getElement(i); 
			Integer sum = first+second+extrasum; 
			if (sum >= 10){
				outSum.appendNode(sum-10);
				extrasum++;
			}
			else {
				outSum.appendNode(sum);
				extrasum = 0;
			}
		}
		if(extrasum!=0)
			outSum.appendNode(1);
		return outSum;
		
	}
	protected static class SingleLinkedList<E> {
		
		
		protected class Node<E> {
			E el;
			Node<E> next = null;
		}
		
		//Instance variables of the LL
		protected Node<E> head = null;
		protected int size = 0; //for ease of implementing the required method
						
		//implementing for testing purposes
		protected void appendNode(E el){
			if (head == null) {
				head = new Node<E>();
				head.el = el;
			}
			else {
				Node <E> curNode = head;
				while(curNode.next != null)
					curNode = curNode.next;
				Node<E> newNode = new Node<E>();
				newNode.el = el;
				curNode.next = newNode;
			}
			size++;
		}
		//Adding get for test purposes - index starts from 0
		public E getElement(int index) {
			if(index >=size)
				return null;
			Node<E> cur = head;
			for(int i = 0; i< index; i++)
				cur = cur.next;
			return cur.el;
		}

		//Adding toString() for testing purposes
		public String toString(){ //As before, the obj should implement toString if custom
			String out = "";
			Node<E> cur = head;
			while(cur != null) {
				out += cur.el+ " ";
				cur = cur.next;
			}
			return out;
		}
		
	}
}
