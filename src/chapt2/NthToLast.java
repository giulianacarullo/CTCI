package chapt2;

import chapt2.RemoveDupULL.UnsortedLinkedList.Node;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 * 
 * @author giulianacarullo
 *
 */
public class NthToLast {
	public static void main(String[] args){
		
	}
	
	protected class SingleLinkedList<E> {
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
		protected E nToLast(int n) {
			if(n > size)
				return null;
			if(n == size)
				return head.el;
			
			return null;
			
		}
		
	}
}
