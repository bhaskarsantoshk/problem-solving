package takeUForward.google;

public class AddTwoFractions {
    public String addFractions(String frac1, String frac2) {
        String[] frac1Arr = frac1.split("/");
        String[] frac2Arr = frac2.split("/");

        int numerator1 = Integer.parseInt(frac1Arr[0]);
        int denominator1 = Integer.parseInt(frac1Arr[1]);

        int numerator2 = Integer.parseInt(frac1Arr[0]);
        int denominator2 = Integer.parseInt(frac1Arr[1]);


        int lcm = (denominator1 * denominator2) / gcd ( denominator1, denominator2);

        int numerator = numerator1 * ( lcm/denominator1) + numerator2 * (lcm/ denominator2);
        int g = gcd(numerator, lcm);
        numerator/= g;
        lcm /= g;
        return numerator+"/"+lcm;
    }

    private int gcd(int a, int b) {
        if ( b == 0) return a;
        return gcd(b, a%b);
    }
}
