//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}

//rotate array by k steps
public int[] rotateArray(int[] arr, int k){
    int len = arr.length;
    int[] newArray = new int[len];

    for(int i=0; i<len; i++){
      newArray[i] = arr[len-k]%len;
    }
    return newArray;
}

//find element index in a sorted array using binary search
int binarySearch(int[] arr, int num){
  if(arr.length == 0){
    return -1;
  }
  int start = 0;
  int end = arr.length -1;

  while(start <= end){
    int mid = (start+end)/2;
    if(arr[mid] == num){
      return mid;
    }else if(num < arr[mid]){
      end = mid-1;
    }else{
      start = mid+1;
    }
  }
  return -1;
}

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	maxSoFar=Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}



//check if there are two elements in array whose sum equals x
//method 1: sort the array, and for each element use binary search to look for x o(nlogn)
//method 2: insert every element into hash table, and for every x, look up it's complement O(1), overall runtime is O(n)
