public class Palindrome{

//using while loop, all alphanumeric
public boolean isPalindrome(String s){
        if(s.isEmpty() || s == null){
            return true;
        }
        s= s.replaceAll("[^A-Za-z0-9 ]+", "").toLowerCase();

        int i = 0;
        int j = s.length() -1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}

public String getLongestPalindrome(String s){
    //generate all substrings of a String
    //check if substring is Palindrome
    //keep track of longest string

    String currentLongest = "";

    int len = s.length;
    for(int i=0; i<len; i++){
      if(currentLongest.length > len-i-1){
        break;
      }
      for(int j=i+1; j<=len; j++){
          String substring = s.substring(i,j);
      }
      if(isPalindrome(substring)){
        currentLongest = substring;
      }
    }
    return currentLongest;
}
