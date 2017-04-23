package chapt2;

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
public class BeginningOfTheLoopTBD {

	public static void main(String[] args) {
		
	}
	/**
	 * Assumption made Single Circular Linked List
	 * 
	 * @author giulianacarullo
	 *
	 * @param <E>
	 */
	protected static class CirclularLinkedList<E> {
		protected class Node<E>{
			E el;
			Node<E> next = null;
		}
		
		Node<E> head = new Node<E>(); //just using head as a sentinel node
		
		protected void append(E el) {
			Node <E> curNode = head.next;
			if(curNode == null) {
				curNode = new Node<E>();
				curNode.el = el;
				curNode.next= head;
			}
			while(curNode.next != head)
				curNode = curNode.next;
			Node<E> newNode = new Node<E>();
			newNode.el = el;
			curNode.next = newNode;
			newNode.next = head;
		}
		
	}
}
