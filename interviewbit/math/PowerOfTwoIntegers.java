package interviewbit.math;

public class PowerOfTwoIntegers {
    public static void main(String[] args){
        PowerOfTwoIntegers obj = new PowerOfTwoIntegers();
        obj.isPower(536870912);
    }
    public int isPower(int A){
        if(A<=0){
            return 0;
        }

        if(A==1){
            return 1;
        }
        double logValue = Math.log(A);
        for(int i=2;i<=A/i;i++){
            double x = logValue / Math.log(i);
            if(x %1 ==0){

                return 1;

            }
        }
        return 0;
    }

    public int isPower2(int A) {
        if(A<=0){
            return 0;
        }

        if(A==1){
            return 1;
        }


        for(int i=2;i<=A/i;i++){
            int result =i;

            while (result <= A){

                if(result == A){
                    return 1;
                }
                result*=i;
            }
        }

        return 0;
    }
}
