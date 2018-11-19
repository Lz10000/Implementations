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
