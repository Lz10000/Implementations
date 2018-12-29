/**
HashMap contains an array of Nodes
Hashing is the process of converting an object to integer form by using method hashCode()
**/

//hashCode() method of object class returns the memory reference of object in integer form,
//In HashMap, hashCode() is used to calculate the bucket and therefore calculate the index.
//HashMap uses equals() to compare the key whether they are equal or not.

// bucket is one element of HashMap array. It is used to store nodes. Two or more nodes can have the same bucket.
//In that case link list structure is used to connect the nodes.

//if calculated index (from hashcode) is already used to store another Node, then new Node is referenced as next Nodes
//In that case, check via hashCode() and equals() method that if both the keys are same.
//If keys are same, replace the value with current value.
//Otherwise connect this node object to the previous node object via linked list and both are stored at index

class HashMap{
  Node[] table;
  final int loadFactor = .75;
  //capacity = #buckets * loadFactor
  final int buckets = 4;
  int capacity = buckets*loadFactor;
  int size = 0;

  public Hash(){
    table = new Node[capacity]();
  }

  class Node{
    Node next;
    Object key;
    Object val;
    int hashCode;

    public Node(Object key, Object val){
      this.key = key;
      this.val = val;
    }
  }

  public void put(Object key, Object val){
    if(key == null){
      return;
    }
    if(atMaxCapacity){
      increaseCapacity();
    }

    int hash = hash(key);
    Node n = new Node(key, val);

    //if table does not have key at hash index, store it there
    if(table[hash] == null){
      table[hash] = n;
      size++;
    }else{
      //if table does have a key at that hash index, then if keys are same, append key to head of node
      Node current = table[hash];
      while(current != null){
        if(current.key.equals(key)){
          //assign it to head of node
          n.next = current;
          table[hash] = n;
          size++;
        }
        //otherwise keep iterating until the end of the linked list
        current = current.next;
      }
      //add to end
      current.next = n;
    }
  }

  public Object get(Object key){
    int hash = hash(key);
    if(table[hash] != null){
      Node current = table[hash];
      while(current != null){
        if(current.key.equals(key)){
          return current.val;
        }
        current = current.next;
      }
    }
    return null;
  }

  public boolean atMaxCapacity(){
    return size == capacity;
  }

  public void increaseCapacity(){
    //add additional buckets * loadFactor to current list
    //copy old list into new list with new size
    this.list = Arrays.copyOf(list, capacity*loadFactor);
  }

  public void remove(Object key){
    int hash = hash(key);
    if(table[hash] != null){
      Node current = table[hash];
      Node prev = null;
      while(current.next != null){
        prev = current;
        if(current.key.equals(key)){
          //remove it from previous node referenced
          table[hash] = prev;
        }
        current = current.next;
      }
    }
  }

  public int hash(Object obj){
      return Math.abs(13*obj.hashCode())%capacity;
  }


}
