package takeUForward.dynamicProgramming;

// https://bit.ly/32tAMUW

public class BooleanEvaluation {
    public static int evaluateExp(String exp) {
        return f(0, exp.length()-1, true, exp);
    }

    private static int f(int i, int j, boolean isTrue, String exp) {
        if ( i > j){
            // should not reach here, just safe side
            return 0;
        }
        if ( i == j){
            if ( isTrue) return ( exp.charAt(i) =='T') ? 1: 0;
            else return exp.charAt(i) == 'F' ? 1:0;
        }
        int ways = 0;

        for ( int index = i+1; index <= j-1; index+=2){
            int lT = f(i, index-1, true, exp);
            int rT = f(index+1, j, true, exp);
            int lF = f(i, index-1, false, exp);
            int rF= f(index+1, j, false, exp);

            char opeartor = exp.charAt(index);
            if ( opeartor == '&'){
                if ( isTrue ) ways+= lT * rT;
                else ways += lT * rF + lF * rT + lF * rF;
            } else if ( opeartor == '|'){
                if ( isTrue) ways += lT*rF + lF*rT + lT*rT;
                else ways += lF * rF;
            } else if ( opeartor == '^'){
                if (isTrue) ways += lT * rF + lF * rT;
                else ways += lT * rT + lF * rF;
            }
        }
        return ways;
    }
}
