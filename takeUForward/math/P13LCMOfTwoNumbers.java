package takeUForward.math;

public class P13LCMOfTwoNumbers {
    public int LCM(int n1, int n2) {
        if ( n1== 0 || n2==0) return 0;
        int min= Math.max(n1,n2);
        int i=1;
        do {
            int multiple = min*i;
            if ( multiple % n1== 0 && multiple %n2 == 0) return multiple;
            i++;
        } while ( true);
    }

    public int LCMOptimized(int n1, int n2) {
        if ( n1== 0 || n2==0) return 0;
        return (n1*n2)/gcd(n1,n2);
    }

    private int gcd(int n1, int n2) {
        if ( n1== 0 || n2==0) return 0;
        while (n1 != 0 && n2!= 0){
            if (n1 > n2) n1= n1%n2;
            else n2 = n2 %n1;
        }
        return (n1==0) ? n2: n1;
    }
}
