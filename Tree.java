public class Tree{

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  TreeNode root;

  public static void main(String[] args) {

    Tree t = new Tree();
    Tree.TreeNode node = t.new TreeNode(1);
  }


  public int maxDepth(TreeNode node) {

    if(node == null ) return 0;
    return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
  }

  public TreeNode deleteNodeBST(TreeNode root, int data){

    if(root == null){
      return null;
    }else if(data < root.val){
      root.left = deleteNodeBST(root.left, data);
    }else if(data > root.val){
      root.right = deleteNodeBST(root.right, data);
    }else{

    	if(root.left == null){
    		return root.right;
    	}else if(root.right == null){
    		return root.left;
    	}

    	TreeNode minNode = findMin(root.right);
    	root.val = minNode.val;
    	root.right = deleteNode(root.right, root.val);
    }
    return root;
  }

  public TreeNode insertNode(TreeNode root, int data){
  	//traverse until you find where it belongs
  	if(root == null){
  		root = new TreeNode(data);
  		return root;
  	}else if(data < root.val){
  		root.left = insertNode(root.left, data);
  	}else if(data > root.val){
  		root.right = insertNode(root.right, data);
  	}
  	return root;
  }

  //check if a tree is balanced
    

  //finds the minimum of a node by traversing the left subtree
  public TreeNode findMinBST(TreeNode node){
  	while(node.left != null){
  		node = node.left;
  	}
  	return node;
  }

  /**
  Depth-First Search
  **/
  //Preorder Binary tree traversal
  //visits root, then left subtree, then right subtree
  //space complexity is O(h) h is height of tree
  public void Preorder(TreeNode node){
    if(node == null) return;
    System.out.println(node.val);
    Preorder(node.left);
    Preorder(node.right);
  }

  //Inorder Binary tree traversal
  //visits left subtree, root, then right subtree
  public void Inorder(TreeNode node){
    if(node == null) return;
    //goes to the leaf node of left subtree
    Inorder(node.left);
    //prints leaf node of left subtree
    System.out.println(node.val);
    Indorder(node.right);
  }

  //Postorder Binary tree traversal
  //visits left subtree, right subtree, then root
  public void Postorder(TreeNode node){
    if(node == null) return;
    Postorder(node.left);
    Postorder(node.right);
    System.out.println(node.val);
  }

  /**
  Breadth-first search start at level 0 (root) then to 1, (left to right)
  also known as level-order. visits all its children before grandchildren
  **/
  //storing a node in a queue, and enqueue the children of the node
  //dequeue the node and visit it
  //
  public breadthFirstSearch(TreeNode node){
    if(node == null) return;
    Queue<TreeNode> queue = new LinkedList();
    //enqueue
    queue.add(node);
    while(!queue.isEmpty()){

      TreeNode current = queue.peek();
      System.out.println(current.val);
      if(current.left != null){
          queue.add(current.left);
      }
      if(current.right != null){
          queue.add(current.right);
      }
      //poll retrieves and removes head element of queue, dequeue
      queue.poll();
    }
  }

}
