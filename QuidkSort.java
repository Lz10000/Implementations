
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