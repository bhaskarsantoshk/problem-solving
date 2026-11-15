package takeUForward.sprint1.patterns;

/*
 **********
 ****  ****
 ***    ***
 **      **
 *        *
 *        *
 **      **
 ***    ***
 ****  ****
 **********
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern19 {
    public void pattern19(int n) {
        // n lines first
        // 5 stars 0 spaces 5 stars
        // 4 stars 2 spaces 4 stars
        // 3 stars 4 spaces 3 stars
        // 2 stars 6 spaces 2 stars
        // 1 stars 8 spaces 1 star

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<= (n-(i-1)); j++){
                System.out.print("*");
            }
            for ( int j=1; j<= 2* (i-1); j++){
                System.out.print(" ");
            }
            for ( int j=1; j<= (n-(i-1)); j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // n lines here too
        // 1 stars 8 spaces 1 stars
        // 2 stars 6 spaces 2 stars
        // 3 stars 4 spaces 3 stars
        // 4 stars 2 spaces 4 stars
        // 5 stars 0 spaces 5 stars

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=i ; j++){
                System.out.print("*");
            }

            // spaces
            for ( int j=1; j<= 2*(n-i); j++){
                System.out.print(" ");
            }

            for ( int j=1; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern19 obj = new Pattern19();
        obj.pattern19(5);
    }
}
