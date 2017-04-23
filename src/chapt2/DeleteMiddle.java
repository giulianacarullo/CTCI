package chapt2;


/**
 * Implement an algorithm to delete a node in the middle of a single linked list, 
 * given only access to that node
 * 
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 * 
 * @author giulianacarullo
 *
 */

public class DeleteMiddle {
	public static void main(String[] args){
		SingleLinkedList<Integer> ll = new SingleLinkedList<>();
		ll.appendNode(1);
		ll.appendNode(2);
		ll.appendNode(3);
		ll.appendNode(4);
		ll.appendNode(5);	
		ll.appendNode(6);
		ll.appendNode(7);
		System.out.println(ll.toString());
		ll.deleteMiddle(4);
		System.out.println(ll.toString());

		
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
		 * Assuming for simplicity of the implementation that elements in the list
		 * are all different (just for testing purposes getting integer as input instead of
		 * Node<E>. 
		 * 
		 * Also assuming that the middle exists -> the size of the list is odd. 
		 * Also assuming that el is the real middle in the list. 
		 * 
		 * The basic idea is to travel the list (storing prev element) until the element is found
		 * 
		 * Traversing N/2 elements, but still O(N)
		 * @return 
		 */
		protected void deleteMiddle(E el) {
			if(head.el == el)
				head = null;
			Node<E> prev = head;
			Node<E> cur = prev.next;
			while(cur.el != el) {
				prev = prev.next;
				cur = cur.next;
			}
			prev.next = cur.next;
			
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
