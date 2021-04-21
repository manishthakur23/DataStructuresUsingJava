package binarySearchTree;

public class BinarySearchTree {
	
	public Node<Integer> insert(Node<Integer> head , Node<Integer> node){
		
		if(head == null) {
			return node;
		}
		
		if(node.getData() < head.getData()) {
			head.setLeftChild(insert(head.getLeftChild(), node));
		}else {
			head.setRightChild(insert(head.getRightChild(), node));
		}
		
		return head;
	}
	
	public Node<Integer> lookUp( Node<Integer> head , int data){
		if(head == null) {
			return null;
		}
		
		if(head.getData() == data) {
			return head;
		}
		
		if( data <= head.getData()) {
			return lookUp(head.getLeftChild(), data);
		}else {
			return lookUp(head.getRightChild(), data);
		}
	}
	
	public void depthfirstpreorder( Node<Integer> root) {
		if(root == null) {
			return;
		}
		print(root);
		depthfirstpreorder(root.getLeftChild());
		depthfirstpreorder(root.getRightChild());
		
	}
	
	public void depthFirstInOrder(Node<Integer> root) {
		if(root == null) {
			return;
		}
		
		depthFirstInOrder(root.getLeftChild());
		print(root);
		depthfirstpreorder(root.getRightChild());
	}
	
	public void depthFirstPostOrder(Node<Integer> root) {
		if(root == null) {
			return;
		}
		depthFirstPostOrder(root.getLeftChild());
		depthFirstPostOrder(root.getRightChild());
		print(root);
	}
	
	public void print(Node<Integer> node) {
		System.out.println("Node :: "+node.getData());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new  BinarySearchTree();
		Node<Integer> head = new Node<Integer>(10);
		Node<Integer> node1 = new Node<Integer>(9);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(12);
		Node<Integer> node4 = new Node<Integer>(11);
		Node<Integer> node5 = new Node<Integer>(7);
		Node<Integer> node6 = new Node<Integer>(1);
		Node<Integer> node7 = new Node<Integer>(17);
		Node<Integer> node8 = new Node<Integer>(19);
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node1)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node2)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node3)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node4)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node5)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node6)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node7)).getData());
		System.out.println("Node inserted in BST :: "+(bst.insert(head, node8)).getData());
		
		System.out.println(" Searched node :: 11 ::"+(bst.lookUp(head, 11)));
		System.out.println(" Searched node :: 20 ::"+(bst.lookUp(head, 20)));
		
		System.out.println("Depth pre order algo");
		bst.depthfirstpreorder(head);
		
		System.out.println("Depth Inorder order algo");
		bst.depthFirstInOrder(head);
		
		System.out.println("Depth Post Order algo");
		bst.depthFirstPostOrder(head);

	}

}
