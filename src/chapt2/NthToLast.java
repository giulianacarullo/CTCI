package chapt2;

import chapt2.RemoveDupULL.UnsortedLinkedList;
import chapt2.RemoveDupULL.UnsortedLinkedList.Node;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 * 
 * @author giulianacarullo
 *
 */
public class NthToLast {
	public static void main(String[] args){
		SingleLinkedList<Integer> ll = new SingleLinkedList<>();
		ll.appendNode(2);
		ll.appendNode(20);
		ll.appendNode(1);
		ll.appendNode(10);
		ll.appendNode(10);	
		ll.appendNode(2);
		ll.appendNode(20);
		ll.appendNode(21);
		System.out.println(ll.toString());
		System.out.println(ll.nToLast(3));
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
		/**
		 * This version supposes that I can use the size of the LL.
		 * That's not tricky at all, in the following solutions, we'll 
		 * remove this assumption.
		 * 
		 * @param n
		 * @return
		 */
		protected E nToLast(int n) {
			if(n > size)
				return null;
			if(n == size)
				return head.el;
			int indexEl = n - size;
			Node<E> cur = head;
			for(int i = 0; i < indexEl; i++)
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
