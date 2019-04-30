package LeetCode;

public class P38CountandSay {
    public String countAndSay(int n) {
        String s= "1";
        for(int i=1; i<n; i++){
            s= sequence(s);
        }
        return s;
    }
// 1, 11, 21, 1211
    private String sequence(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);

        for(int i=1; i<s.length() ; i++){
            if(c == s.charAt(i)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(c);
                c= s.charAt(i);
                count=1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

}
