package chapt3;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks
 * 
 * @author giulianacarullo
 *
 */
public class MyQueue {
	public static void main(String[] args) throws Exception{
		//testing a bit - considering integers
		MyQueueImpl<Integer> q = new MyQueueImpl();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println("Initial queue: " + q);
		q.dequeue();
		q.dequeue();
		//at this point the queue should be: 3-4
		System.out.println(q);
		//if I add another el (5), it should be 3-4-5
		q.enqueue(5);
		System.out.println(q);	
	}
	
	/**
	 * A queue implement a FIFO policy. 
	 * The idea is to use one stack for the pushes and when a deque is required to
	 * put everything into the second stack and that do a top().  
	 * @author giulianacarullo
	 *
	 * @param <E>
	 */
	protected static class MyQueueImpl<E>{
		Stack<E> st1; //used for enqueues
		Stack<E> st2; //used for dequeue
		boolean lastEnqueue = true; //enables to swith between stacks
		
		protected MyQueueImpl(){ 
			st1 = new Stack<>();
			st2 = new Stack<>(); //st2 could be lazy initialized at the first dequeue. 
		}
		
		/**
		 * The idea is: if the last op we did is an enqueue, we can continue to push
		 * into st1. Otherwise we have to move elements from st2 to st1 and then push. 
		 * 
		 * Thus, in the worst case, this method has time complexity O(N) 
		 * where N is the number of elements in the queue. 
		 * 
		 * @param e
		 */
		protected void enqueue(E e) {
			if(lastEnqueue) {
				st1.push(e); 
				return;
			}
			//we need to move elements first
			while(!st2.isEmpty())
				st1.push(st2.pop());
			//and the adding the new element
			st1.push(e);
			lastEnqueue = true;
		}
		

		/**
		 * This method is pretty similar to enqueue. 
		 * If the last operation was an enqueue it needs to move elements from s1 to s2 
		 * and then top.
		 * Otherwise it can just return st2 top.
		 * 
		 * Thus, this element has O(N) time complexity. 
		 * 
		 * @return
		 * @throws Exception
		 */
		protected E dequeue() throws Exception {
			// checking if we can dequeue elements
			if(isEmpty())
				throw new Exception("empty queue"); //it would be better to design a new Ex
			// if an enqueue is the last operation we did,
			// we first need to move elements from st1 to st2.
			if(lastEnqueue) {
				while(!st1.isEmpty())
					st2.push(st1.pop());
					lastEnqueue = false;
			}
			return st2.pop();
		}
		
		protected boolean isEmpty(){
			if(st1.isEmpty() && st2.isEmpty())
				return true;
			return false;
		}
		
		@Override
		public String toString() {
			String qu = "";
			if(lastEnqueue) {
				while(!st1.isEmpty()) {
					E cur = st1.pop();
					qu = " " + cur + qu;
					st2.push(cur);
				}
				lastEnqueue = false;
			}
			else {
				while(!st2.isEmpty()) {
					E cur = st2.pop();
					qu = qu + cur + " ";
					st1.push(cur);
				}
				lastEnqueue = true;
			}
			return qu;
			
		}
	}
	
}
