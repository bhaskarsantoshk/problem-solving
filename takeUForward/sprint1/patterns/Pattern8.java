package takeUForward.sprint1.patterns;

/*
 *********
  *******
   *****
    ***
     *
 */

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern8 {
    public void pattern8(int n) {
        // 1 . n lines ( 1 -> n outer loop )
        // 2. spaces stars spaces
        // for n = 5
        // 0 spaces 9 stars 0 spaces
        // 1 spaces 7 stars 1 spaces
        // 2 spaces 5 stars 2 spaces
        // 3 spaces 3 stars 3 spaces
        // 4 spaces 1 stars 4 spaces

        for ( int i=1; i<=n; i++){
            // spaces
            for ( int spaces = 1; spaces <= i-1; spaces++){
                System.out.print(" ");
            }


            // stars
            for ( int stars = 1; stars <= 2 * (n -i)+1 ; stars++){
                System.out.print("*");
            }

            // spaces ( this may not be necessary if the judge doesn't expect it because the visible out is same without the below
            for ( int spaces = 1; spaces <= i-1; spaces++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern8 obj = new Pattern8();
        obj.pattern8(5);
    }
}
