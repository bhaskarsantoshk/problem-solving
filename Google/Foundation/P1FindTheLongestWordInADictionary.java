package Google.Foundation;

import java.util.ArrayList;
import java.util.List;

public class P1FindTheLongestWordInADictionary {
    /*
    https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string/#!
     */
    // O ( N * M ) Solution
    public String longestSubsequence (List<String> dictionary, String word){
        int maxLen = 0;
        String result = "";
        for ( String w: dictionary ){
            if ( w.length() > maxLen && isSubsequence(w, word)){
                maxLen = w.length();
                result = w;
            }
        }
        return result;
    }

    private boolean isSubsequence(String w, String word) {
      int j=0;
      // w = "apple" word = "abbpple"
      for ( int i=0; i<word.length(); i++){
          if ( j < w.length() && word.charAt(i) == w.charAt(j)){
              j++;
          }
      }
      return j==w.length();
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        String[] input= {"able", "ale", "apple", "bale", "kangaroo"};
        for ( String word: input){
            list.add(word);
        }
        P1FindTheLongestWordInADictionary obj = new P1FindTheLongestWordInADictionary();
        System.out.println(obj.longestSubsequence(list, "abppplee"));
    }
}
