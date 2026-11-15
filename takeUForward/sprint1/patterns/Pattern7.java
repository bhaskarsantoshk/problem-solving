package takeUForward.sprint1.patterns;

/*
     *
    ***
   *****
  *******
 *********

 */

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern7 {
    public void pattern7(int n) {
        // 1 . n lines ( 1 -> n outer loop )
        // 2. spaces stars spaces
        // for = 4
        // 3 spaces 1 * 3 spaces
        // 2 spaces 3 stars 2 spaces
        // 1 space 5 stars 1 space
        // 0 space 7 stars 0 space
        // spaces are like 3 2 1 0, stars are like 1,3,5,7
        // N-i spaces ( figured out ) + whatever no of starts + N-i spaces

        for ( int i=1; i<=n; i++){
            // spaces
            for ( int spaces = 1; spaces <= n-i; spaces++){
                System.out.print(" ");
            }

            // stars
            for ( int stars = 1; stars <= 2 * i -1 ; stars++){
                System.out.print("*");
            }

            // spaces ( this may not be necessary if the judge doesn't expect it because the visible out is same without the below
            for ( int spaces = 1; spaces <= n-i; spaces++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern7 obj = new Pattern7();
        obj.pattern7(5);
    }
}
