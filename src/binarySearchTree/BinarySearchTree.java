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
	
	//Minimum value in BST
	public int minimumValue( Node <Integer> head) {
		if(head == null) {
			return -1;
		}
		
		if(head.getLeftChild() == null) {
			return head.getData();
		}
		
		return minimumValue(head.getLeftChild());
		}
	
	//Maxmium depth of the BST
	public int maximumDepth(Node <Integer> head) {
		if(head == null) {
			return 0;
		}
		
		if(head.getLeftChild() == null & head.getRightChild() == null) {
			return 0;
		}
		
		int leftChildDepth = 1+maximumDepth(head.getLeftChild());
		int rightChildDepth = 1+maximumDepth(head.getRightChild());
		
		return Math.max(leftChildDepth, leftChildDepth);
	}
	
	//Mirroring BST
	public void mirror(Node<Integer> head) {
		if(head == null) {
			return;
		}
		
		mirror(head.getLeftChild());
		mirror(head.getRightChild());
		
		Node<Integer> temp = head.getLeftChild();
		head.setLeftChild(head.getRightChild());
		head.setRightChild(temp);
	}
	
	//Print BST nodes between range
	public void findValuesBetweenRange(Node <Integer> root, int low, int high) {
		if(root == null) {
			return;
		}
		
		if(root.getData()>=low) {
			findValuesBetweenRange(root.getLeftChild(), low, high);
		}
		
		if(root.getData() >= low && root.getData() <= high) {
			print(root);
		}
		
		if(root.getData()<= high) {
			findValuesBetweenRange(root.getRightChild(), low, high);
		}
	}
	
	//Check whether it is BST
	
	public boolean isBST(Node <Integer> root ,  int min , int max) {
		if(root ==  null) {
			return false;
		}
		
		if(root.getData() >= min && root.getData() <= max) {
			return true;
		}
		
		return isBST(root.getLeftChild(), min, root.getData()) && isBST(root.getRightChild(), root.getData(), max);
	}
	
	//Number of different trees
	public int NumberofUniqueTrees( int numberOfNodes) {
		if( numberOfNodes <= 1) {
			return 1;
		}
		int sum = 0;
		for(int i = 1 ; i < numberOfNodes ; i++ ) {
			int leftChildTress = NumberofUniqueTrees(i-1);
			int rightChildTress = NumberofUniqueTrees(numberOfNodes - i);
			
			sum = sum + (leftChildTress*rightChildTress);
		}
		
		return sum;
		
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
		Node<Integer> node7 = new Node<Integer>(0);
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

		System.out.println("Minimum value in BST ::"+bst.minimumValue(head));
		
		System.out.println("Maximum depth of BST ::"+bst.maximumDepth(head));
		
		System.out.println("Mirroring BST");
		bst.mirror(head);
		
		System.out.println("Depth pre order algo after mirroring ");
		bst.depthfirstpreorder(head);
		
		System.out.println("Node between 10 to 15");
		bst.findValuesBetweenRange(head, 0, 21);
		
		
		System.out.println(" IS BST :: "+bst.isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE));
		int n = 3;		
		System.out.println("Number of unique trees for "+n+" nodes :: "+bst.NumberofUniqueTrees(n));
		
		
	}

}
