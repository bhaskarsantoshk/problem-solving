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