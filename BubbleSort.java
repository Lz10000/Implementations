 public void bubbleSort(int[] arr){
              boolean swapped = true;
              int temp = 0;
              while(swapped){
                     swapped = false;
                     for(int i= 0; i<arr.length-1; i++){
                           if(arr[i+1] < arr[i]){
                                  temp = arr[i];
                                  arr[i] = arr[i+1];
                                  arr[i+1] = temp;
                                  swapped = true;
                           }
                     }
              }
       }
}