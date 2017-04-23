package chapt2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list 
 * 
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author giulianacarullo
 *
 */
public class RemoveDupULL {

	/*
	 * Possible assumptions:
	 * 
	 * Single or double linked list? 
	 * Going for single (double does not change much for this exercise)
	 * 
	 * Supposing that we have a LL of integers for testing purposes
	 */
	public static void main(String[] args){
		//testing
		UnsortedLinkedList<Integer> ll = new UnsortedLinkedList<>();
		ll.appendNode(2);
		//ll.appendNode(2);
		//ll.appendNode(2);
		ll.appendNode(20);
		ll.appendNode(1);
		ll.appendNode(10);
		ll.appendNode(10);	
		ll.appendNode(2);
		ll.appendNode(20);
		ll.appendNode(21);
		System.out.println(ll.toString());
		//ll.remDuplicate();
		ll.removeDupNoBuf();
		System.out.println(ll.toString());
	}
	
	//Using a inner class to model the LL and implement the required method
	protected static class UnsortedLinkedList<E>{
		protected class Node<E>{
			protected E el;
			protected Node<E> next = null;
		}
		
		//Instance variables of the LL
		protected Node<E> head = null;
		
		
		//implementing for testing purposes
		protected void appendNode(E el){
			if (head == null) {
				head = new Node<E>();
				head.el = el;
				//head.next = null;
			}
			else {
				Node <E> curNode = head;
				while(curNode.next != null)
					curNode = curNode.next;
				Node<E> newNode = new Node<E>();
				newNode.el = el;
				curNode.next = newNode;
			}
		}
		
		/**
		 * This is the original version, where we can use added memory.
		 * 
		 * The idea is to scan the LL first and insert the elements into the hashMap.
		 * At this time, however I do not need key, value: I just need the key, thus I can
		 * use a  HashSet for the purpose. 
		 * 
		 * When a duplicate (i.e. it exists in the hashmap), is found, it is removed 
		 * from the LL.
		 * 
		 * I pick up a hashset to check for duplicates, 
		 * due to the fact that it helps to 
		 * 1) avoid duplicates; 2) O(1) lookup time 3) I love hashmaps (kidding...maybe not!)
		 * 
		 */
		protected void remDuplicate(){
			//if we are using custom obj make sure to implement clone for type E
			Set<E> dup = new HashSet<E>(); 
			//traveling the LL
			Node<E> cur = head;
			Node<E> prev = head; //I also need to store previous value
			if (cur != null){
				dup.add(cur.el);
				//System.out.println("init "+ cur.el + " ");
				prev = cur;
				cur = cur.next;
			}
			else
				return;
			while(cur != null) { //we may also check for tail due to the structure
				if(dup.contains(cur.el)){
					// removal needed
					prev.next = cur.next;
					cur = cur.next;
				}
				else {
					dup.add(cur.el);
					prev = cur;
					cur = cur.next;
				}
			}
		}
		
		/**
		 * This removal is pretty similar to the one you would do on arrays (two for)
		 * but it keeps track of the element to inspect (prevFirst), and prev and cur 
		 * element to traverse the LL. 
		 * 
		 * 
		 */
		protected void removeDupNoBuf(){
			Node<E> prevFirst = head;
			//Node<E> cur =null;
			Node<E> prev = head;
			Node<E> cur = prev.next;
			while (prevFirst!= null) {
				prev = prevFirst;
				cur = prev.next;
				while(cur != null) {
					if(prevFirst.el == cur.el) {
						prev.next = cur.next;
						cur = cur.next;
					}
					else {
						prev = cur;
						cur = cur.next;
					}
				}
				prevFirst = prevFirst.next;
				
			}
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
