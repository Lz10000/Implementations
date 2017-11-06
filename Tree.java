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
    //traverse tree until node is found, then delete
    //if it has children, reassign them to root of deleted node

    //case 1 no child

    //case 2 one child

    //case 3 two children --> find minimum value of right subtree
    //or min value of left subtree-
    //and replace value of node with new min value, delete duplicate
    //reduce case 3 to 2 or 1

    if(root == null){
      return;
    }
    else if(data < root.val){
      root.left = deleteNodeBST(root.left, data);
    }else if(data > root.val){
      root.right = deleteNodeBST(root.right, data);
    }else{
      //case 1: no child
      if(root.left == null && root.right == null){

      }
    }

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
      //poll retrieves and removes head element of queue
      queue.poll();
    }
  }

}
