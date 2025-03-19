package company.microsoft;

public class P345ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;
        while ( left < right){
            while ( left < str.length && "AEIOUaeiou".indexOf(str[left]) < 0 ){
                left++;
            }
            while ( right >= 0 && "AEIOUaeiou".indexOf(str[right]) < 0 ){
                right--;
            }
            if ( left < right ) {
                char temp = str[left];
                str[left++] = str[right];
                str[right--] = temp;
            }
        }
        return String.valueOf(str);
    }
}
