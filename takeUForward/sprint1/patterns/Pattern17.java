package takeUForward.sprint1.patterns;

/*
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern17 {
    public void pattern17(int n) {
        // n=5 5 lines outer loop i =1 -> 5
        // 4 spaces  A  4 spaces
        // 3 spaces ABA 2 spaces
        // 2 space ABCBA 1 space
        // 1 space ABCDCBA 1 space
        // 0 space ABCDEDCBA 0 space
        // n-i spaces + (2 * i -1) chars ( i chars + i-1 in reverse )
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            char c = 'A';
            for ( int j=1; j<=i; j++){
                System.out.print(c);
                if ( j < i) c = (char) (c+1);
            }
            for ( int j=1; j<=i-1; j++){
                c = (char) (c-1);
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern17 obj = new Pattern17();
        obj.pattern17(5);
    }
}
