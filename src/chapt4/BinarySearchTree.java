package chapt4;
/**
 * Brushing up Binary Search Trees
 * 
 * Just insertion at the moment. 
 * 
 * @author giulianacarullo
 *
 */
public class BinarySearchTree {
	protected class Node {
		int key;
		Node parent;
		Node left;
		Node right;
		protected Node(){}
	}
	
	//Instance var
	Node root;
	
	public void insert(int el){
		if(root == null) {
			System.out.println("Adding root");
			Node newEl = new Node();
			newEl.key = el;
			root = newEl;
		}
		else
			insert(root, el);
	}
	
	private void insert(Node node, int el){
		if(el >= node.key) {
			if(node.right == null) {
				System.out.println("Adding "+el + "as right child of " + node.key);
				Node newEl = new Node();
				newEl.key = el;
				newEl.parent = node;
				node.right = newEl;
			}
			else 
			 insert(node.right, el);
		}
		else{
			if(node.left == null) {
				System.out.println("Adding "+el + "as left child of " + node.key);
				Node newEl = new Node();
				newEl.key = el;
				newEl.parent = node;
				node.left = newEl;
			}
			else
			insert(node.left, el);
		}
		
	}
}
