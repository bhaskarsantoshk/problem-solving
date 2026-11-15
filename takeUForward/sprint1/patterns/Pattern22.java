package takeUForward.sprint1.patterns;

/*
5 5 5 5 5 5 5 5 5
5 4 4 4 4 4 4 4 5
5 4 3 3 3 3 3 4 5
5 4 3 2 2 2 3 4 5
5 4 3 2 1 2 3 4 5
5 4 3 2 2 2 3 4 5
5 4 3 3 3 3 3 4 5
5 4 4 4 4 4 4 4 5
5 5 5 5 5 5 5 5 5
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern22 {
    public void pattern22(int n) {
        // one of the worst problems, you can either remember the solution or pray no one would ask this question

        /*
5 5 5 5 5 5 5 5 5
5 4 4 4 4 4 4 4 5
5 4 3 3 3 3 3 4 5
5 4 3 2 2 2 3 4 5
5 4 3 2 1 2 3 4 5
5 4 3 2 2 2 3 4 5
5 4 3 3 3 3 3 4 5
5 4 4 4 4 4 4 4 5
5 5 5 5 5 5 5 5 5
*/

       // convert the above to this

        /*
0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 0
0 1 2 2 2 2 2 1 0
0 1 2 3 3 3 2 1 0
0 1 2 3 4 3 2 1 0
0 1 2 3 3 3 2 1 0
0 1 2 2 2 2 2 1 0
0 1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0
         */


        for ( int i=0; i<=2*n-2; i++){
            for ( int j=0; j<= 2*n-2; j++){
                int top = i, bottom = (2*n-2)-i;
                int left = j, right = (2*n-2)-j;
                int min = Math.min( top, bottom);
                min = Math.min(min, Math.min(left, right));
                System.out.print(n-min);
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        Pattern22 obj = new Pattern22();
        obj.pattern22(5);
    }
}
