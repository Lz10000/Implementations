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

public void insertionSort(int[] input){
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
              }
          }
      }
}

public void selectionSort(int[] arr){
	//image holding cards and sorting them
	//compare the rest of the cards with the minimum
	int minValue, minIndex, temp = 0;
	for(int i=0; i<arr.length; i++){
		minValue = arr[i];
		minIndex = i;
		for(int j = i; j<arr.length; j++){
			if(arr[j] < minValue){
				minValue = arr[j];
				minIndex = j;
			}
		}
		if(minValue < arr[i]){
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}


public class MergeSort {

    public static void main(String[] args) {

    }

    public static void mergeSort(int[] inputArray) {
        int size = inputArray.length;
        if (size < 2)
            return;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        //split the array into left and right side arrays
        for (int i = 0; i < mid; i++) {
            left[i] = inputArray[i];

        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = inputArray[i];
        }
        //recursively do it until size is 2
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputArray);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}


public void quicksort(int low, int high, int[] numbers) {
               int i = low, j = high;

               int pivot = numbers[low + (high-low)/2];

               // Divide into two lists
               while (i <= j) {
// If the current value from the left list is smaller than the pivot    element then get the next element from the left list
                   while (numbers[i] < pivot) {
                       i++;
                   }
                   while (numbers[j] > pivot) {
                       j--;
                   }

                   // If we have found a value in the left list which is larger than
// the pivot element and if we have found a value in the right   list which is smaller than the pivot element then we exchange the
                   //values. As we are done we can increase i and j
                   if (i <= j) {
                       int temp = numbers[i];
                       numbers[i] = numbers[j];
                       numbers[j] = temp;
                       i++;
                       j--;
                   }
               }

               if (low < j)
                   quicksort(low, j, numbers);
               if (i < high)
                   quicksort(i, high, numbers);
}
