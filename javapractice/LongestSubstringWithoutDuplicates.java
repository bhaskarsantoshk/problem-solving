package javapractice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {
    public static String longestSubString(String s){
        String result = "";
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            set = new HashSet<>();
            String temp = subStringWithNoDuplicates(s, i);
            if(temp.length() > result.length()){
                result = temp;
            }
        }
        return result;
    }

    private static String subStringWithNoDuplicates(String s, int fromindex) {
        StringBuffer sb = new StringBuffer();
        Set<Character> set = new HashSet<>();
        for(int i = fromindex ; i< s.length() ; i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String [] args){
        String s = "I am Batman";
        System.out.println(longestSubString(s));
    }
}
