package chapt4;

import java.util.ArrayList;
import java.util.List;

import chapt4.BinaryTree.Node;


/**
 * Implement a function to check if a tree is balanced. 
 * For the purposes of this question, a balanced tree is defined 
 * to be a tree such that no two leaf nodes differ in distance from 
 * the root by more than one. 
 * 
 * @author giulianacarullo
 *
 */
public class CheckBalancedTree {
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.printPreorder();
		System.out.println();
		System.out.println("Balanced: " + checkBalanced(bt));
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		bt.printPreorder();
		System.out.println();
		System.out.println("Balanced: " + checkBalanced(bt));
	}
	
	/**
	 * 
	 * A simple idea could be to scan the tree two times. One for minDepth, 
	 * the other for the maxDepth. If the two differs from just 1 the the three is
	 * balanced. This algorithm would take O(log n)
	 * 
	 * @param t
	 * @return
	 */
	public static boolean checkBalanced(BinaryTree t){
		int min = minDepth(t.root);
		int max = maxDepth(t.root); 
		return (max-min <=1);
	}
	
	private static int minDepth(Node node) {
		if(node == null) 
			return 0;
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}
	private static int maxDepth(Node node) {
		if(node == null) 
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}
}
