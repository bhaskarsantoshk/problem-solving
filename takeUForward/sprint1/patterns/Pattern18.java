package takeUForward.sprint1.patterns;

/*
E
DE
CDE
BCDE
ABCDE
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern18 {
    public void pattern18(int n) {
        // n = 5 5 lines i = 1 -> 5
        // each line will have i chars,  start with 'A'+ (n-i), decrement
        for ( int i=1; i<=n; i++){
            char c = (char) ('A' + ( n-i));
            for ( int j=1; j<=i; j++){
                System.out.print(c+" ");
                c = (char)( c+1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern18 obj = new Pattern18();
        obj.pattern18(5);
    }
}
