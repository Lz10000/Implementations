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
    reverse = (num%10)+(reverse*10);
    num = num/10;
  }
  return reverse;
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
