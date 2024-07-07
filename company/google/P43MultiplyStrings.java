package company.google;

public class P43MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n= num2.length();
        int [] res = new int[m+n];

        for ( int i = m-1; i >= 0; i--){
            for ( int j= n-1; j >= 0; j--){
                int mul = ( num1.charAt(i)-'0' ) * ( num2.charAt(j)-'0');
                int sum = mul + res[i+j+1];
                res[i+j+1] = sum %10;
                res[i+j] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for ( int digit: res ) if (!(sb.length() == 0 && digit==0)) sb.append(digit);
        return sb.isEmpty() ? "0": sb.toString();
    }
}
