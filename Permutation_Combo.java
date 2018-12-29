//string permutation, order matters
//ex: abc, prints abc, acb, bac, bca... etc
public void permutation(String str){
  permutation("", str);
}

public void permutation(String prefix, String str){
      int n = str.length();
      if(n == 0){
        System.out.println(prefix);
      }else{
        for(int i=0; i<str.length(); i++){
            permutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1));
        }
      }
}

//string combination + subset: a, ab, abc, b, bc,
public static void comb2(String s) {
  comb2("", s);
}

public void comb2(String prefix, String s) {
    System.out.println(prefix);
    for (int i = 0; i < s.length(); i++)
      comb2(prefix + s.charAt(i), s.substring(i + 1));
}

//Given a list of lists of chars, print all combos
//ex: [['a','b','c'], [d,e], [f,g,h]]
//prints: adf, adg, adh, aef, aeg, aeh, bdf, etc.

//Given two integers n and k, return all possible combinations
//of k numbers out of 1 ... n.
/*
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combList = new ArrayList<List<Integer>>();
        combine(combList, new ArrayList<Integer>(), 1, n, k);
        return combList;
}

public static void combine(List<List<Integer>> combList, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combList.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combList, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
}

/**
Given an integer array, find number of ways to calculate a target number using only array elements and addition or subtraction operator.
*/

int findTotalWays(ArrayList<Integer> arr, int i, int k)
{
    // If all elements are processed and
    // target is not reached, return 0
    if (i >= arr.size() && k != 0)
        return 0;

    // If target is reached, return 1
    if (k == 0)
        return 1;

    // Return total count of three cases
    // 1. Don't consider current element
    // 2. Consider current element and subtract it from target
    // 3. Consider current element and add it to target
    return findTotalWays(arr, i + 1, k)
           + findTotalWays(arr, i + 1, k - arr[i])
           + findTotalWays(arr, i + 1, k + arr[i]);
}

/**
Given a value n = 12, count the total number of ways we can make 12 given
coins in denominations of {1, 2, 5}
m = number of coins
**/

//recursive solution
static int count( int[] coins, int m, int n )
    {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;
        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count( coins, m - 1, n ) +
               count( coins, m, n-coins[m-1] );
    }

//dynamic programming O(mn)
int change(int amount, int[] coins){
  int[] combinations = new int[amount+1];
  //for each coin, check if they can make amount
  for(int i=0; i<coins.length; i++){
    for(int j=1; j<= combinations.length; j++){
      if(j >= coin){
        combinations[j]+=combinations[j-coin];
      }
    }
  }
  return combination[amount];
}

//combination sum
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

*/
public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i+1); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}

//combo sum II
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target
*/
public List<List<Integer>> combinationSum2(int[] nums, int target) {
   List<List<Integer>> list = new LinkedList<List<Integer>>();
   backtrack(list, new ArrayList<Integer>(), nums, target, 0);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {

   if(remain < 0) return; /** no solution */
   else if(remain == 0) list.add(new ArrayList<>(tempList));
   else{
      for (int i = start; i < nums.length; i++) {
         if(i > start && cand[i] == nums[i-1]) continue; /** skip duplicates */
         tempList.add(nums[i]);
         backtrack(list, tempList, nums, remain - nums[i], i+1);
         tempList.remove(tempList.size() - 1);
      }
   }
}

//combo sum III
/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
*/
public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<Integer>(), k, n, 1);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
    if(tempList.size() > k) return; /** no solution */
    else if(tempList.size() == k && remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(list, tempList, k, remain-i, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}


//knap sack recursive
/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
*/

int knapSack(int wt, int[] weights, int[] values, int n){
  if(n == 0 && wt == 0){
    return 0;
  }else if(weights[n-1] > wt){
    return knapSack(wt, weights, values, n-1);
  }else{
    return Math.max(values[n-1] + knapSack(wt-weights[n-1], weights, values, n-1),
                     knapSack(wt, weights, values, n-1) );
  }
}

//dynamic programming
int knapSack(int wt, int[] weights, int[] values, int n){
  int i, j;
  int K[][] = new int[n+1][wt+1];
  for(i = 0; i<=n; i++){
    for(j = 0; j <= wt; j++){
      if(i == 0 || j == 0){
        K[i][j] = 0;
      }else if(weights[i-1] <= j){
        K[i][j] = Math.max(values[i-1] + K[i-1][j-weights[i-1]], K[i-1][j]);
      }else{
        K[i][j] = K[i-1][j];
      }
    }
  }
  return K[n][wt];
}
