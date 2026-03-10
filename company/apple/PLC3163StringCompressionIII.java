package company.apple;

public class PLC3163StringCompressionIII {
    public String compressedString(String word) {
        int i =0, j=0, count = 0;
        StringBuilder sb = new StringBuilder();
        while ( j < word.length()){
            count = 0;
            while ( j < word.length() && word.charAt(i) == word.charAt(j) && count < 9){
                j++; count++;
            }
            sb.append(count).append(word.charAt(i));
            i=j;
        }
        return sb.toString();
    }
}
