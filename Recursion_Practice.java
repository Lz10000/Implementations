/**
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
**/

public int bunnyEars2(int bunnies) {
  if (bunnies == 0) return 0;
  if(bunnies % 2 == 0) {
    return 3+bunnyEars2(bunnies-1);
  }else{
    return 2+bunnyEars2(bunnies-1);
  }
}

/**
Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).

factorial(1) → 1
factorial(2) → 2
factorial(3) → 6
**/

public int factorial(int n) {
  if(n == 0) return 0;
  if(n ==1 ) return 1;
  return n*factorial(n-1);
}

/**
Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

count7(717) → 2
count7(7) → 1
count7(123) → 0
**/

public int count7(int n) {
  if (n == 0) return 0;
  if(n % 10 == 7) {
    return 1+count7(n/10);
  }
  return count7(n/10);
}

/**
We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.

triangle(0) → 0
triangle(1) → 1
triangle(2) → 3
**/

public int triangle(int rows) {
  if(rows == 0) return 0;
  return rows+triangle(rows-1);
}

/**
Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.

countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0
**/

public int countX(String str) {
  if (str == "") return 0;
  if(!str.equals("x") && str.length() == 1) return 0;
  if(str.equals("x")){
    return 1;
  }
  return countX(str.substring(0,1)) + countX(str.substring(1));
}

/**
Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.

countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
**/

public int countHi(String str) {
  if(str.length() < 2) return 0;
  if(str.equals("hi") && str.length() == 2) {
    return 1;
  }
  if(str.substring(0,2).equals("hi") && str.length() > 2){
    return 1+countHi(str.substring(2));
  }
  return countHi(str.substring(1));
}

/**
Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

changePi("xpix") → "x3.14x"
changePi("pipi") → "3.143.14"
changePi("pip") → "3.14p"
**/

public String changePi(String str) {
  if(str.length() < 2) return str;
  if(str.equals("pi") && str.length() == 2) {
    return "3.14";
  }
  if(str.substring(0,2).equals("pi") && str.length() > 2) {
    return "3.14"+changePi(str.substring(2));
  }
  return str.substring(0,1)+changePi(str.substring(1));
}

/**
Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

powerN(3, 1) → 3
powerN(3, 2) → 9
powerN(3, 3) → 27
**/
public int powerN(int base, int n) {
  if(n == 0) return 0;
  if(n == 1) return base;
  return base*powerN(base, n-1);
}

/**
Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

sumDigits(126) → 9
sumDigits(49) → 13
sumDigits(12) → 3
**/
public int sumDigits(int n) {
  if(n == 0 ) return 0;
  return (n%10)+sumDigits(n/10);
}

/**
Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

allStar("hello") → "h*e*l*l*o"
allStar("abc") → "a*b*c"
allStar("ab") → "a*b"
**/
public String allStar(String str) {
  if(str.length() == 0) return str;
  if(str.length() == 1) return str;
  if(str.length() == 2) {
    if(!str.substring(1,2).equals("*") ){
      str = str.substring(0,1)+"*"+ str.substring(1,2)+str.substring(2);
    }
    return str;
  }
  return allStar(str.substring(0,1)+"*")+ allStar(str.substring(1));
}

/**
Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

array6([1, 6, 4], 0) → true
array6([1, 4], 0) → false
array6([6], 0) → true
**/
public boolean array6(int[] nums, int index) {
  if(nums.length == 0) return false;
  if(nums[index] == 6) return true;
  if(index >= nums.length-1) return false;
  return array6(nums,index+1);
}

/**
Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".

stringClean("yyzzza") → "yza"
stringClean("abbbcdd") → "abcd"
stringClean("Hello") → "Helo"
**/
public String stringClean(String str) {
  if(str.length() <= 1) return str;
  if(str.length() == 2) {
    if(str.charAt(0) == str.charAt(1)){
      return str.substring(0,1);
    }
    return str;
  }
  if(str.charAt(0) == str.charAt(1)) {
    return stringClean(str.substring(1));
  }else{
    return str.substring(0,1)+stringClean(str.substring(1));
  }
}

/**
Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".

parenBit("xyz(abc)123") → "(abc)"
parenBit("x(hello)") → "(hello)"
parenBit("(xy)1") → "(xy)"
**/

public String parenBit(String str) {
  if(str.length() <= 1) return str;
  if(str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') {
    return str;
  }
  if(str.charAt(0) == '(') {
    return parenBit(str.substring(0,str.length()-1));
  }else{
    return parenBit(str.substring(1,str.length()));
  }
}

/**
Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.

strDist("catcowcat", "cat") → 9
strDist("catcowcat", "cow") → 3
strDist("cccatcowcatxx", "cat") → 9
**/
public int strDist(String str, String sub) {
  if(str == "") return 0;
  if(str.length() < sub.length()) return 0;
  if(str.substring(0, sub.length()).equals(sub) && str.substring(str.length() - sub.length()).equals(sub)){
    return str.length();
  }
  if(str.substring(0, sub.length()).equals(sub)) {
    return strDist(str.substring(0, str.length()-1), sub);
  }else{
    return strDist(str.substring(1), sub);
  }
}

/**
Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.

strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0
**/

public int strCount(String str, String sub) {
  if(str == "") return 0;
  if(str.length() < sub.length()) return 0;
  if(str.substring(0,sub.length()).equals(sub)) {
    return 1 +strCount(str.substring(sub.length()), sub);
  }else{
    return strCount(str.substring(1), sub);
  }
}
