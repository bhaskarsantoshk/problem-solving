package data_structures.strings;

import static Recursion.DataFormatter.print;
import static Recursion.DataFormatter.swap;

public class WordReverser {
    public static void reverseWords (char[] words) {
        if ( words == null || words.length < 2) return;
        reverse(words, 0, words.length-1);
        int start = 0;
        int end;
        while ( true ){
            while(start < words.length && words[start]==' '){
                start++;
            }
            if ( start >= words.length-1){
                break;
            }
            end = start +1;
            while ( end < words.length && words[end] != ' '){
                end++;
            }
            reverse(words, start, end-1);
            start = end;
        }
    }

    private static void reverse(char[] sentence, int start, int end) {
        if ( start >= end) return;
        while ( start < end){
            swap(sentence, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        String s = "Hello World";
        char[] words = s.toCharArray();
        print(words);
        reverseWords(words);
        print(words);
    }
}
