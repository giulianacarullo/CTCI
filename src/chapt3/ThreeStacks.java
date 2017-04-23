package chapt3;
/**
 * Describe how you could use a single array to implement three stacks. 
 * 
 * Considering integers for simplicity
 * 
 * @author giulianacarullo
 *
 */
public class ThreeStacks{

public static void main(String[] args){
		// testing a bit
		int stackSize = 3;
		ThreeStacksImpl stacks = new ThreeStacksImpl(stackSize);
		stacks.push(1, 1);
		stacks.push(1, 2);
		stacks.push(1, 3);
		stacks.push(2, 4);
		stacks.push(2, 5);
		stacks.push(2, 6);
		stacks.push(3, 7);
		stacks.push(3, 8);
		stacks.push(3, 9);
		System.out.println("Stack 1:");
		stacks.printStack(1);
		System.out.println("Stack 2:");
		stacks.printStack(2);
		System.out.println("Stack 3:");
		stacks.printStack(3);
		System.out.println(stacks.pop(1));
		System.out.println(stacks.pop(2));
		System.out.println(stacks.pop(3));
		System.out.println(stacks.top(2));
		stacks.printStack(2);
}

public static class ThreeStacksImpl {
	int stacks[];
	
	/** 
	 * first assumption is to have three stacks of the same length.
	 * thus constructing the array with the stack's size as input.
	 */

	int[] stackStarts = new int[3];
	int[] stackTops = {0,0,0};
	int stackSize = 0;
	public ThreeStacksImpl(int stackSize){
		stacks = new int[stackSize*3];
		stackStarts[0]  = 0;
		stackStarts[1] = stackSize;
		stackStarts[2] = stackSize*2;
		this.stackSize = stackSize;
	}
	
	//Assuming 1, 2, 3 and all positive integers
	public int top(int stackNo){
		if(!isEmpty(stackNo)){
			int value = stacks[stackStarts[stackNo-1]+stackTops[stackNo-1] -1];
			stackTops[stackNo-1] = stackTops[stackNo-1]-1;
			return value;
		}
		return -1;
	}
	public int pop(int stackNo){
		if(!isEmpty(stackNo)){
			return stacks[stackStarts[stackNo-1]+stackTops[stackNo-1]-1];
		}
		return -1;
	}
	
	public boolean push(int stackNo, int el){
		
		if(checkPush(stackNo)) {
			stacks[stackStarts[stackNo-1] + stackTops[stackNo-1]] = el;
			stackTops[stackNo-1]++;
			return true;
		}
		return false;
	}
	
	
	public boolean isEmpty(int stackNo){
		if(stackTops[stackNo-1] == 0)
			return true;
		return false;
	}
	
	
	private boolean checkPush(int stackNo){
		if(stackNo == 1 && stackTops[0] < stackSize) return true;
		if(stackNo == 2 && stackTops[1] < stackSize*2) return true;
		if(stackNo == 3 && stackTops[2] < stackSize*3) return true;
		return false;	
	}
	
	//just for testing purposes
	public void printStack(int stackNo){
		int begin = stackStarts[stackNo-1];
		for (int i = begin; i < begin + stackTops[stackNo-1]; i++)
				System.out.print(stacks[i] + " ");
		System.out.println();
	}
}
	
	
}
