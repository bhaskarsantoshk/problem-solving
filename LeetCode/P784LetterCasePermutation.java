package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if ( S == null ){
            return result;
        }
        dfs(S.toCharArray(), result, 0);
        return result;
    }

    private void dfs(char[] a, List<String> result, int pos) {
        if ( pos == a.length ){
            result.add(new String(a));
            return;
        }
        if ( a[pos]>='0' && a[pos]<='9' ){
            dfs(a, result, pos+1);
            return;
        }
        a[pos] = Character.toLowerCase(a[pos]);
        dfs(a, result, pos+1);
        a[pos] = Character.toUpperCase(a[pos]);
        dfs(a, result, pos+1);
    }

    public static void main(String[] args){
        P784LetterCasePermutation obj = new P784LetterCasePermutation();
        System.out.println(obj.letterCasePermutation("a1b2"));
    }


}
