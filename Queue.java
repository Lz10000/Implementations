public class Queue{
    
class Node{
    Node next;
    int val;

    public Node(int val){
        this.val = val;
    }
}

Node head;
Node tail;

public void enqueue(int val){
    Node n = new Node(val);
    if(head == null){
        head = n;
        head.next = tail;
    }
    if(tail == null){
        tail = n;
    }else if(tail != null){
        tail.next = n;
        tail = tail.next;
    }
}

public int dequeue(){
    if(head != null){
        int val = head.val;
        head = head.next;
        return val;
    }
    return -1;
}


}
