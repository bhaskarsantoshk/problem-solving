package takeUForward.math;

public class P8CheckIfTheNumberIsArmstrong {
    public boolean isArmstrong(int n) {
        if ( n == 0) return true;
        int pow = len(n);
        int num = 0;
        int temp = n;
        while ( temp > 0){
            num += (int)Math.pow(temp%10, pow);
            temp/=10;
        }
        return num == n;
    }

    private int len(int n) {
        int count = 0;
        while ( n > 0){
            count++;
            n/=10;
        }
        return count;
    }

    public static void main(String[] args){
        P8CheckIfTheNumberIsArmstrong obj = new P8CheckIfTheNumberIsArmstrong();
        System.out.println(obj.isArmstrong(153));
    }
}
