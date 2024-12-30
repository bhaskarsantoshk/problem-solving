package company.karat;

public class P1160FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int [] freq = new int[26];
        int count=0;
        for ( char c : chars.toCharArray()) freq[c-'a']++;
        for ( String word: words){
            if( canBeFormed(word, freq)) count+= word.length();
        }
        return count;
    }

    private boolean canBeFormed(String word, int[] freq) {
        int [] wordCharFreq = new int[26];
        for ( char c : word.toCharArray()) wordCharFreq[c-'a']++;
        for ( int i=0; i<26; i++) {
            if ( freq[i] < wordCharFreq[i]) return false;
        }
        return true;
    }
}
