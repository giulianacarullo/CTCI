package chapt3;
/**
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? 
 * 
 * Push, pop and min should all operate in O(1) time
 * 
 * @author giulianacarullo
 *
 */

public class MinStack {

	public static void main(String[] args){
		// testing
		MinStackImple stack = new MinStackImple(5); 
		stack.push(10);
		stack.push(2);
		stack.printStack();
		System.out.println("Min so far: " + stack.min());
		stack.top();
		stack.printStack();
		stack.push(1);
		stack.printStack();
		System.out.println("Min so far: " + stack.min());
		stack.top();
		stack.printStack();

		System.out.println("Min so far: " + stack.min());


	}
	
	/**
	 * 
	 * Assuming integers once again. 
	 * The idea is to let each node to also keep track of the min element between those 
	 * under it.
	 *
	 */
	protected static class MinStackImple{
		protected class MinNode{
			int el;
			int min;
		}
		MinNode[] stack;
		MinNode top = null; //could be avoided
		int indexTop = 0;
		// initSize just for simplicity of the implementation
		protected MinStackImple(int initSize){
			stack = new MinNode[initSize];
		}
		protected boolean push(int el){
			if(isFull())
				return false;
			if(isEmpty()){
				MinNode node= new MinNode();
				node.el = el;
				node.min = el;
				stack[indexTop] = node;
				top = node;
				indexTop++;
				return true;
			}
			int newMin = Math.min(top.min, el);
			MinNode node = new MinNode();
			node.el = el;
			node.min = newMin;
			top = node;
			stack[indexTop] = node;
			indexTop++;
			return true;
		}
		protected int top(){
			if(isEmpty())
				return -1;
			int val = top.el;
			stack[indexTop] = null;
			indexTop--;
			if(isEmpty())
				top = null;
			else
				top = stack[indexTop-1];
			return val;
			
		}
		
		//assuming for simplicity all positive numbers (signalling something wrong with -1)
		protected int pop(){
			if(isEmpty())
				return -1;
			return top.el;
		}
		protected int min(){
			if(isEmpty())
				return -1;
			return top.min;
		}
		
		protected boolean isEmpty(){
			if(top == null)
				return true;
			return false;
		}
		protected boolean isFull(){
			if(indexTop == stack.length)
				return true;
			return false;
		}
		
		//just for testing purposes
		public void printStack(){
			for (int i = 0; i < indexTop; i++)
					System.out.print(stack[i].el + " ");
			System.out.println();
		}
	}
}
