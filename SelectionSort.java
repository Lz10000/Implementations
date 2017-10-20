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
