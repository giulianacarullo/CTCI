package chapt4;

public class BTTester {
	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<>();
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		bt.insert(8);
		bt.printPreorder();
		
	}
}
