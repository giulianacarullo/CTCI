package chapt3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Imagine a (literal) stack of plates If the stack gets too high, it might topple 
 * Therefore, in real life, we would likely start a new stack when the previous stack 
 * exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this SetOfStacks should be 
 * composed of several stacks, and should create a new stack once the previous 
 * one exceeds capacity SetOfStacks push() and SetOfStacks pop() should behave 
 * identically to a single stack (that is, pop() should return the same values as 
 * it would if there were just a single stack)
 * 
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on 
 * a specific sub-stack
 * 
 * 
 * 
 * @author giulianacarullo
 *
 */
public class StackOfPlates {
	public static void main(String[] args) throws Exception{
		SetOfStacks ss = new SetOfStacks(2);
		ss.push(1);
		ss.push(2);
		ss.push(3);
		System.out.println("Pop "+ ss.pop());
		System.out.println("Top "+ ss.top());
		System.out.println("Top "+ ss.top());
		System.out.println("Top "+ ss.top());
		
	}
	
	/**
	 * For this solution I am going to use an ArrayList of Stacks,
	 * since it is easy to keep on with the ordering for top and pop
	 * 
	 * @author giulianacarullo
	 *
	 */
	protected static class SetOfStacks{
		ArrayList<Stack<Integer>> plates = new ArrayList<>();
		int currentStack = 0;
		int thr;
		
		protected SetOfStacks(int thr){
			this.thr = thr; 
		}
		/**
		 * Every time a new element must be stored, it is first checked if the threshold 
		 * is reached. In this case a new Stack is generated. 
		 * Otherwise, it is possible to continue to fill in the currrent stack. 
		 * 
		 * @param el
		 */
		protected void push(int el){
			if(isEmpty()){
				Stack<Integer> curStack = new Stack<>();
				plates.add(curStack);
			}
			Stack<Integer> curStack = plates.get(currentStack);
			if (curStack.size() == thr){
				//a new stack must be created
				Stack<Integer> ns = new Stack<Integer>();
				ns.push(el);
				plates.add(ns);
				currentStack++;
			}
			else
				curStack.push(el); 
		}
		protected int pop() throws Exception{
			if(isEmpty())
				throw new Exception("empty stack");
			
			Stack<Integer> curStack = plates.get(currentStack);
			//At this stage curStack is never empty, since this possibility is managed by top()
			return curStack.peek();
			
		}
		
		protected int top() throws Exception{
			if(isEmpty())
				throw new Exception("empty stack");
			Stack<Integer> curStack = plates.get(currentStack);
			if(curStack.isEmpty()) {
				plates.remove(currentStack);
				currentStack--;
			}
			curStack = plates.get(currentStack);
			return curStack.pop();
		}
		
		protected boolean isEmpty(){
			if (currentStack == 0 && plates.size() == 0)
				return true;
			return false;
		}
	}
}
