package interviewbit.arrays;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if ( A.size() == 0 ){
            return 0;
        }
        int moves= 0;
        int x = A.get(0);
        int y= B.get(0);
        for ( int i= 1; i< A.size(); i++){
            moves += Math.max ( Math.abs(A.get(i)-x), Math.abs(B.get(i)-y));
            x = A.get(i);
            y = B.get(i);
        }
        return moves;
    }
}
