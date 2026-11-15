package takeUForward.sprint1.patterns;

/*
      *
      **
      ***
      ****
      *****
      ****
      ***
      **
      *
 */

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern10 {
    public void pattern10(int n) {
        // 0 spaces 1 stars
        // 0 spaces 2 stars
        // 0 spaces 3 stars
        // 0 spaces 4 stars
        // 0 spaces 5 stars

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 0 spaces 4 stars
        // 0 spaces 3 stars
        // 0 spaces 2 stars
        // 0 spaces 1 stars


        for ( int i=1; i<=n-1; i++){
            for ( int j=1; j<=n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern10 obj = new Pattern10();
        obj.pattern10(5);
    }
}
