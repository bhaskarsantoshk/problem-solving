# Recursion
* When a function calls itself
* Until a specified condition is met
* Stack overflow / Segmentation Fault -> When there are numerous function calls keep waiting in the stack as they are not completed, and the memory gets full
* Base condition : stopping condition for a function
* Recursion Tree : a tree representation of function calls
* We can solve recursion problems using parameterized way or the functional way ( function returns the result )
* Parameterized:
```Java
   public class SumOfFirstNNumbers {
    public void sum ( int n){
      sum ( n, 0);
    }

    private void sum(int i, int sum) {
        if ( i < 1) {
            System.out.println(sum);
            return;
        }
        sum ( i-1, sum+i);
    }

    public static void main (String[] args){
        SumOfFirstNNumbers obj = new SumOfFirstNNumbers();
        obj.sum(10);
    }
  }
```
* Functional:
```Java
public int sumFunctional(int n){
        if ( n < 0) return 0;
        return n + sumFunctional(n-1);
}
```

* Factorial
```Java
private static int factorial(int n){
        if ( n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }


    private static int factorialIterative ( int n){
        int res = 1;
        for ( int i=1; i<= n; i++){
            res *= i;
        }
        return res;
    }

```

* Reverse an Array
```Java
    public static void reverse(int[] a){
        reverse(a, 0, a.length-1);
    }

    private static void reverse(int []a, int start, int end){
        if ( start>= end) return;
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
        reverse(a, start+1, end-1);
    }

    public static void invert(int a[], int index){
       if ( index < a.length/2){
        swap(a, index, a.length-1-index);
        invert(a, index+1);
       }
     }
```

* Palindrome Checker
```Java
public class PalindromeChecker {
    public static boolean isPalindrome(String s){
        if ( s.length() == 0 || s.length() == 1){
            return true;
        }
        if ( s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindrome(s.substring(1,s.length()-1));
        }
        return false;
    }

    public static boolean isPalindrome ( String s, int index){
        if ( index >= s.length()/2) return true;
        if ( s.charAt(index) != s.charAt(s.length()-index-1)) return false;
        return isPalindrome(s, index+1);
    }
}
```

* Multiple Recursion Calls
* Example: f(5) = f(4) + f(3)
```Java
public static int fibonacci(int n){
        if ( n <= 1){
            return n;
        }
        return fibonacci(n-1)+ fibonacci(n-2);
}
```
* Recursion - Print All Subsequence
* Subsequence -> list of elements in order
* Sub-array -> contiguous list of elements
* if [ 3 1 2 ] is the input array -> {3}, {1}, {2}, {3 1} , {3 2}, {3 1 2}, {} are subsequences
* We can use the pattern [ take / not take], for example -> 3 1 is [take , take,  not-take]
* Structure to follow
```Sudocode
func (index, arr []){
    if ( index >= n ) {
        print array;
        return
    }
    arr.add(arr[index]);
    func(index+1, arr); // take
    arr.remove(arr[arr.length-1])
    func(index+1, arr); // not take
}
```
```Java

public class AllSubSequences {
    public void printAllSubSequences( int[] arr){
        printAllSubSequences(new ArrayList<Integer>(), arr, 0, arr.length);
    }

    private void printAllSubSequences(ArrayList<Integer> list, int[] arr, int index, int length) {
        if ( index >= length ){
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        printAllSubSequences(list, arr, index+1, length);
        list.remove(list.size()-1);
        printAllSubSequences(list, arr, index+1, length);
    }

    public static void main(String[] args){
        int [] arr = { 3, 1, 2};
        AllSubSequences obj = new AllSubSequences();
        obj.printAllSubSequences(arr);
    }

}
```
## All patterns in Recursion
### Printing Subsequences whose sum is K
* ( TAKE | NOT TAKE ) pattern
```sudocode
f( index, {},arr[], sum, K ){
   if ( index >= n ) {
   if ( sum == K ) print array
   }
   return;
   
   {}.add(arr[index])
   f( index+1, { .. }, arr[], sum+arr[index], K)
   {}.removeLast();
   f( index+1, { .. }, arr[], sum, K)
}
```
```Java
public class AllSubsequencesWithSumK {
    public void printAllSubsequencesWithSumK(int[] arr, int K){
        printAllSubsequencesWithSumK(new ArrayList<Integer>(), arr, 0, 0, K);
    }

    private void printAllSubsequencesWithSumK(ArrayList<Integer> list, int[] arr, int index, int sum, int K) {
        if ( index >= arr.length) {
            if ( sum == K) System.out.println(list);
            return;
        }
        list.add(arr[index]);
        printAllSubsequencesWithSumK(list, arr, index+1, sum+arr[index], K);
        list.removeLast();
        printAllSubsequencesWithSumK(list, arr, index+1, sum, K);
    }

    public static void main(String[] args){
        int [] arr = { 1, 2, 1, 4, 3};
        AllSubsequencesWithSumK obj = new AllSubsequencesWithSumK();
        obj.printAllSubsequencesWithSumK(arr, 4);
    }
}
```

### Print Any One Subsequence of Sum K
* We can use a global variable boolean flag at the base condition for the above
* Global variables are Not recommended as they cause butterfly affect 
* Technique to print one subsequences
  * base case should return true / false in the func
  * only if it's false , you can call the second func
  * similarly, return true if the second func gives true
  * else return false
```Java
public class AnySubsequencesWithSumK {
    public void printAnySubsequencesWithSumK(int[] arr, int K){
        printAnySubsequencesWithSumK(new ArrayList<Integer>(), arr, 0, 0, K);
    }

    private boolean printAnySubsequencesWithSumK(ArrayList<Integer> list, int[] arr, int index, int sum, int K) {
        if ( index >= arr.length) {
            if ( sum == K) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        boolean res = printAnySubsequencesWithSumK(list, arr, index+1, sum+arr[index], K);
        if ( res ) return true;
        list.removeLast();
        res = printAnySubsequencesWithSumK(list, arr, index+1, sum, K);
        if ( res ) return true;
        return false;
    }

    public static void main(String[] args){
        int [] arr = { 1, 2, 1, 4, 3};
        AnySubsequencesWithSumK obj = new AnySubsequencesWithSumK();
        obj.printAnySubsequencesWithSumK(arr, 4);
    }
}
```
### Count All Subsequence of Sum K
```sudocode
f() {
    base case
        return 1 if condition satisfies
        return 0 if condition fails
    // if more func calls req, run a for loop and add it to sum
    l = f()
    r = f()
    return l+r;
}
```

```Java
public class CountSubsequencesWithSumK {
    public int countSubsequencesWithSumK(int[] arr, int K){
       return countSubsequencesWithSumK(new ArrayList<Integer>(), arr, 0, 0, K);
    }

    private int countSubsequencesWithSumK(ArrayList<Integer> list, int[] arr, int index, int sum, int K) {
        if ( index >= arr.length) {
            if ( sum == K) return 1;
            return 0;
        }
        list.add(arr[index]);
        int left = countSubsequencesWithSumK(list, arr, index+1, sum+arr[index], K);
        list.removeLast();
        int right = countSubsequencesWithSumK(list, arr, index+1, sum, K);
        return left+right;
    }

    public static void main(String[] args){
        int [] arr = { 1, 2, 1, 4, 3};
        CountSubsequencesWithSumK obj = new CountSubsequencesWithSumK();
        System.out.println(obj.countSubsequencesWithSumK(arr, 4));
    }
}

```

* Note: one additional base case we can write to optimze the above 
* if sum > k return // works only if array contains positive numbers
