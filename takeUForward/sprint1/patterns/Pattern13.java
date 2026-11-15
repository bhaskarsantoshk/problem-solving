package takeUForward.sprint1.patterns;

/*
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern13 {
    public void pattern13(int n) {
        // n=5 5 lines outer loop i =1 -> 5
        // each line again i numbers ( num start with 1 increments each time )
        int num = 1;
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=i; j++){
                System.out.print(num+++" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern13 obj = new Pattern13();
        obj.pattern13(5);
    }
}
