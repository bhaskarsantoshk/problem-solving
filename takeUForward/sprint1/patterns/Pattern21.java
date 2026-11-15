package takeUForward.sprint1.patterns;

/*
 *****
 *   *
 *   *
 *   *
 *****
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern21 {
    public void pattern21(int n) {
        // n lines 1st and last all stars
        // rest * + n-2 spaces + *
        for ( int i=1; i<=n; i++) System.out.print("*");
        System.out.println();
        for ( int i=1; i<=n-2; i++){
            System.out.print("*");
            for ( int j=1; j<=n-2; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        if ( n < 2) return;
        for ( int i=1; i<=n; i++) System.out.print("*");
    }

    public static void main(String[] args){
        Pattern21 obj = new Pattern21();
        obj.pattern21(5);
        obj.pattern21(2);
    }
}
