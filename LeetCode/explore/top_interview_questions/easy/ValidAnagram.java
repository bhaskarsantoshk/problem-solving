package LeetCode.explore.top_interview_questions.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int a[] = new int[26];
        for ( char c: s.toCharArray()){
            a[c-'a']++;
        }
        for ( char c: t.toCharArray()){
            a[c-'a']--;
        }
        for ( int num : a ){
            if ( num != 0){
                return false;
            }
        }
        return true;
    }
}
