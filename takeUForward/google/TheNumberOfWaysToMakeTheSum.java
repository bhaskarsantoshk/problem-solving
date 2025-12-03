package takeUForward.google;

public class TheNumberOfWaysToMakeTheSum {
    public int numberOfWays(int n) {
        int countWays = 0;
        int MOD = (int) 10e9+7;
        for ( int countFour = 0; countFour <=2 ; countFour++){
            int rem = n - countFour*4;
            if ( rem < 0) continue;
            for ( int countSix = 0; countSix* 6 <= rem; countSix++){
                int remAfterSix = rem-countSix*6;

                for ( int countTwo = 0; countTwo* 2 <= remAfterSix; countTwo++){
                    int remAfterTwo = remAfterSix-countTwo*2;
                    countWays = (countWays+1)%MOD; // optional check : if ( remAfterTwo >= 0 )
                }
            }
        }
        return countWays;
    }
}
