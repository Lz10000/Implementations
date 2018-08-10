//check string has unique characters without external data structures
public boolean hasUniqueChars(String str){
    // HashSet<Char> charSet = new HashSet<Char>();
    boolean[] ascii = new boolean[128];

    for(int i=0;i<str.length();i++){
      if(ascii[str.charAt(i)]){
        return false;
      }
      ascii[str.charAt(i)] = true;
    }
    return true;
}


//check  if a number is prime
public boolean isPrime(int n){
  for(int i=2; i<n; i++){
    if(n%i==0){
      return false;
    }
  }
  return true;
}

//get the nth prime number
//2,3,5,7,11
public int getNthPrime(int n){
    //keep iterating infinitely until prime number is equal to nth position
    int counter = 0;
    int num = 1;
    int i;

    while(counter < n){
        num++;
        for(i=2; i<=num; i++){
          if(num%i == 0){
            break;
          }
        }
        if(i == num){
          counter++;
        }
    }
    return num;
}

//convert decimal to Binary
public String decimalToBinary(int dec){
    String binary="";
    while(dec != 0){
      binary = binary+decimal%2+"";
      dec = dec/2;
    }
    return binary;
}

//reverse a number
public int reverseNum(int num){
  int reverse;
  while(num != 0){
    reverse = (num%10)+(num*10);
    num = num/10;
  }
  return reverse;
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

//get nth fibonacci number recursively
int fib(int n){
  if(n <= 1){
    return n;
  }
  return fib(n-2)+fib(n-1);
}

//nth fibonacci number iteratively
int fibIterative(int n){
  int a = 0;
  int b = 1;

  for(int i = 0; i<n; i++){
    int temp = a;
    a = b;
    b = temp+a;
  }
  return a;
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

//spiral matrix
public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }


/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
**/

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

public class Solution {

private int n;
private int m;

public int numIslands(char[][] grid) {
    int count = 0;
    n = grid.length;
    if (n == 0) return 0;
    m = grid[0].length;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++)
            if (grid[i][j] == '1') {
                DFSMarking(grid, i, j);
                ++count;
            }
    }
    return count;
}

private void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
}
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
//Trapping rain water
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
*/
public int trap(int[] A){
    int a=0;
    int b=A.length-1;
    int max=0;
    int leftmax=0;
    int rightmax=0;
    while(a<=b){
        leftmax=Math.max(leftmax,A[a]);
        rightmax=Math.max(rightmax,A[b]);
        if(leftmax<rightmax){
            max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
            a++;
        }
        else{
            max+=(rightmax-A[b]);
            b--;
        }
    }
    return max;
}

//Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
public String intToRoman(int num) {

    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    StringBuilder sb = new StringBuilder();

    for(int i=0;i<values.length;i++) {
        while(num >= values[i]) {
            num -= values[i];
            sb.append(strs[i]);
        }
    }
    return sb.toString();
}

/*You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
*/

public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<matrix.length/2;i++){
            for(int j =i;j<n-i-1;j++){
                int temp =matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
}

/*
  Determine if a 9x9 Sudoku board is valid
*/
public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            if (board[i][j] != '.') {
                String b = "(" + board[i][j] + ")";
                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                    return false;
            }
        }
    }
    return true;
}
