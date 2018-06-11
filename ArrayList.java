public class ArrayList<Object>{

    int arraySize = 20;
    Object[] arr;

    int currSize = 0;

    public ArrayList<Object>(){
      arr = new Object[arraySize]();
    }

    public Object get(int index){
      if(index >= 0 && index < currSize){
        return arr[index];
      }else{
        throw new ArrayIndexOutOfBoundsException();
      }
    }

    public void add(Object obj){
        if(currSize > arraySize){
            Object[] newArray = new Object[arraySize*2];
            for(int i=0; i<arraySize; i++){
                newArray[i] = arr[i];
            }
            newArray[arraySize+1] = obj;
            arr = newArray;
            currSize++;
            arraySize*=2;
        }else{
            arr[currSize+1] = ojb;
            currSize++;
        }
    }

    public Object remove(int index){
      if(index >= 0 && index < currSize ){
        Object obj = arr[index];
        int tmp = index;
        while(tmp < currSize){
          arr[tmp] = arr[tmp+1];
          arr[tmp+1] = null;
          tmp++;
        }
        curSize--;
        return obj;

      }else{
        throw new ArrayIndexOutOfBoundsException();
      }
    }

    public int size(){
      return currSize;
    }

    public boolean isEmpty(){
      return size == 0;
    }

}
