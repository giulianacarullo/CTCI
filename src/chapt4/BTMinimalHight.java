package chapt4;

import chapt4.BinaryTree.Node;

/**
 * Given a sorted (increasing order) array, write an algorithm 
 * to create a binary tree with minimal height.
 * 
 * Minimal height means that we want a balanced binary tree. 
 * So the idea is to: 
 * 		* first element: root
 *      * then like we are performind a BFS we add elements from left to right
 *      * if all the level is full, then we add a left child to the left element 
 *      * on the outmost left. 
 *      
 * However we have a representation invariant, that we may consider: 
 * the array is sorted. We may exploit this invariant such as:
 * 
 * if the tree is empty: root
 * otherwise pick the next minimum node in the tree that does not have 
 * both left and right nodes. If it hasn't left, add new node as left child, otherwise
 * right child. 
 * 
 * However this may not add much (I'll rethink about it later on).
 * 
 * An easy recusion can be defined by: pick the centrail element, which becomes the root
 * every element on the left will be in the left subtree, every element on the right on the right
 * subtree. 
 * 
 * @author giulianacarullo
 *
 */
public class BTMinimalHight {
	public static void main(String[] args) {
		BT bt = new BT();
		
		int[] array = {1,2,3,4,5,6};
		bt.root = bt.addBalanced(array, 0, array.length-1);
		bt.preorderToString(bt.root);
		System.out.println();
		System.out.println("depth:" + bt.depth(bt.root));
	}
	
	protected static class BT {
		protected class Node {
			int el;
			Node left;
			Node right;
			
			protected boolean isLeaf() {
				if(left == null && right == null)
					return true;
				return false;
			}
		}
		
		Node root = null;
		
		protected Node addBalanced(int[] values, int s, int e) {
			if (e < s)
				return null;
			int mid = (s + e) / 2;
			Node newNode = new Node();
			newNode.el = values[mid]; 
			newNode.left = addBalanced(values, s, mid-1);
			newNode.right = addBalanced(values, mid+1, e);
			return newNode;		
		}
		
		private boolean supp(Node root, int value,int count) {
			Node newEl = new Node();
			newEl.el = value;
			if(root.left == null && count %2 != 0) {
				System.out.println("L: Adding" + value + " as child of "+ root.el);
				root.left = newEl;
				return true;
			}
			else if (root.right == null && count %2 != 0) {
				root.right = newEl;
				System.out.println("R: Adding" + value + " as child of "+ root.el);
				return true;
			}
			if(count%2 == 0)
				supp(root.right, value, count++);
			else
				supp(root.left, value, count++);
			return true;
				
		}
		
		//preorder to string
		protected void preorderToString(Node node) {
			if(node != null) {
				System.out.print(node.el + " ");
				preorderToString(node.left);
				preorderToString(node.right);
			}
		}
		
		protected int depth(Node node) {
			if(node==null) {
				//System.out.println("Visiting leaf" + node.el);
				return 0;
			}
			//System.out.println("Visiting " + node.el);
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
		
	}
}
