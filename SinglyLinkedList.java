
public class SinglyLinkedList {
    public Node head;

    class Node {
        public Node next;
        public final int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public SinglyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();

        link.addToEnd(2);
        link.addToEnd(3);
        link.addToEnd(4);
        link.addToEnd(5);
//        link.deleteAtEnd();
//        link.deleteAtEnd();
//        link.deleteAtEnd();
        link.deleteNode(4);
        link.deleteNode(5);

        Node n = link.head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }

         link.reverse();
         Node reverse = link.head;
         while (reverse != null) {
         System.out.println(reverse.data);
         reverse = reverse.next;
         }

    }

    // insert node at start of linked list
    public void addToStart(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        }else{
            node.next = head;
            head = node;
        }
    }

    // delete node at start of linked list
    public void deleteFromStart() {
        Node node = head.next;
        head = node;
    }

    // add node at the end of linked list
    public void addToEnd(int data) {
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    //delete a node in the linked list
    public void deleteNode(int n){
        if(head == null){
            return;
        }
        Node current = head;
        if(current.data == n){
            head = head.next;
        }else{
            while(current.next != null){
                if(current.next.data == n){
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

    }

    //delete node at the end of linked list
    public void deleteAtEnd(){
        if(head == null){
            return;
        }
        Node prev = null;
        Node current = head;

        while(current.next != null){
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = null;
        } else {
            prev.next = current.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // length
    public int length() {
        int counter = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

}
