package company.google.arrays;

public class P43MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length()+num2.length()];
        for ( int i=num1.length()-1; i>=0; i--){
            for ( int j=num2.length()-1; j >= 0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = res[i+j+1] + mul;
                res[i+j+1] = sum %10;
                res[i+j] += sum /10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for ( int digit : res){
            if (!(sb.isEmpty() && digit == 0)){
                sb.append(digit);
            }
        }
        return sb.isEmpty() ? "0": sb.toString();
    }
}
