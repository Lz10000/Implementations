public class Stack{

    Node first;

    class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    public Stack(){
       this.first = null;
    }

    //removes the first node
    public Node pop(){
        if(this.first != null){
           Node oldFirst = this.first;
           Node newFirst = first.next;
           this.first = newFirst;
        }
        return oldFirst;
    }

    public push(Node newNode){
      if(this.first != null){
        Node oldFirst = this.first;
        this.first = newNode;
        this.first.next = oldFirst;
      }
    }

}
