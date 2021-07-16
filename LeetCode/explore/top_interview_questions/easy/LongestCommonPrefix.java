package LeetCode.explore.top_interview_questions.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if ( strs == null || strs.length == 0 ) return "";
        String res = strs[0];
        int index = 1;
        while ( index < strs.length ){
            while ( strs[index].indexOf(res) != 0){
                res = res.substring(0, res.length()-1);
            }
            index++;
        }
        return res;
    }
}
