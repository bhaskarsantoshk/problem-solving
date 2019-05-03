package company.microsoft;

public class MultiplyStrings {
    public String multiply(String A, String B) {
        int m = A.length(), n= B.length();
        int [] res = new int[m+n];

        for(int i= m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int mul = (A.charAt(i)-'0') * (B.charAt(j)-'0');
                int p1= i+j, p2= i+j+1;
                int sum = mul + res[p2];
                res[p1] += sum/10;
                res[p2] = (sum) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : res){
            if(!(sb.length()==0 && p==0)){
                sb.append(p);
            }
        }
        return sb.length()==0 ? "0" : sb.toString() ;
    }

    public static void main(String[] args){
        MultiplyStrings obj = new MultiplyStrings();
        System.out.println(obj.multiply("9999", "9999"));
    }
}
