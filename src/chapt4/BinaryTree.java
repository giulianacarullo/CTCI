package chapt4;
/**
 * Brushing up BTs and they will be used just for testing purposes into the various
 * coding questions.
 * 
 * Disclamaire: it is not a proper and complete BT, just testing :)
 *  
 * @author giulianacarullo
 *
 */
public class BinaryTree <T> {
	protected class Node<T>{
		protected T key;
		protected Node<T> left;
		protected Node<T> right;
		
		protected boolean isLeaf() {
			if(left == null && right ==null)
				return true;
			return false;
		}
	}
	//Instance Variable
	protected Node<T> root;
	
	/**
	 * The new node is inserted as first leaf in the tree. 
	 * This is currently generative xD. The outcome is not a balanced tree. 
	 * (thus useful for the purposes of CheckBalancedTree)
	 * 
	 * @param key
	 */
	public void insert(T key) {
		if(root == null) {
			Node<T> newNode = new Node<T>();
			newNode.key = key;
			root = newNode;
		}
		else
			insert(root,key);
	}
	private boolean insert(Node<T> node, T key){
		Node<T> newNode = new Node<T>();
		newNode.key = key; 
		if(node.left == null) {
			node.left = newNode;
			return true;
		}
		else if(node.right == null) {
			node.right = newNode;
			return true;
		}
		else if(!insert(node.left, key))
				return insert(node.right, key);
		return true;
	}
	
	public void printPreorder() {
		preorderToString(root);
		
	}
	//preorder to string
	private void preorderToString(Node<T> node) {
		if(node != null) {
			System.out.print(node.key + " ");
			preorderToString(node.left);
			preorderToString(node.right);
		}
		
	}
}
	
