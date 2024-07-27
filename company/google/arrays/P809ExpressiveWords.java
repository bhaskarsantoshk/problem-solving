package company.google.arrays;

public class P809ExpressiveWords {

    /*
    1. Clarify
If word1 == word2, is word2 stretchy? Answer is Yes
If word2 contains a character that word1 doesn't contain, is word2 stretched from word1? Like word2 = "aaaaab", word1 = "aa". Answer is No, every character in word2 must be from word1 or stretched from a character in word1
2. Idea
If word2 is stretched from word1, the following conditions must be met:

Rule 1: Compressed(word1) must be the same as compressed word2 [what is compressed word? Remove all duplicate characters in a word and keep the original order of the rest characters, you will get a compressed word]
Rule 2: For each distinct character in word1 and word2, the consecutive repeated times must fulfill:
repeated1 = repeatedTimes(char c in word1)
repeated2 = repeatedTimes(char c in word2)
(repeated1 < repeated2 && repeated2 >= 3) || repeated1 == repeated2
Because every distinct character in word1 and word2 must meet rule2, we turn our direction to find one charcter that doesn't meet rule 2, whenever we find one character that doesn't meet rule2, we know word2 is not stretched from word1.

So, when compressed(word1) != compressed(word2) or we encounter a character c that (repeated1 >= repeated2 || repeated2 < 3) && repeated1 != repeated2, we know word2 is not stretched from word1
     */
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for ( String word: words){
            if ( isStretchy(word, s) ) count++;
        }
        return count++;
    }

    private boolean isStretchy(String orig, String stretched){
        int i=0, j=0;
        while ( i < orig.length() && j < stretched.length() ){
            if ( orig.charAt(i) != stretched.charAt(j) ) return false;

            int repeatedLenOrig = getRepeatedLen(orig, i);
            int repeatedLenStretched = getRepeatedLen(stretched, j);

            if ( (repeatedLenOrig > repeatedLenStretched || repeatedLenStretched < 3) && repeatedLenOrig != repeatedLenStretched ) return false;

            i += repeatedLenOrig;
            j += repeatedLenStretched;

        }
        return i == orig.length() && j == stretched.length();
    }

    private int getRepeatedLen(String s, int start){
        int end = start;
        while ( end < s.length() && s.charAt(end) == s.charAt(start)) end++;
        return end-start;
    }
}
