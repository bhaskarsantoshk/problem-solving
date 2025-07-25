package company.karat.revision;

public class P1160FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int [] freqChars = new int[26];
        int count = 0;
        for ( char c: chars.toCharArray()) freqChars[c-'a']++;
        for ( String word: words){
            int [] freqWord = new int[26];
            for ( char c: word.toCharArray()) freqWord[c-'a']++;
            boolean canBeFormed = true;
            for ( int i=0; i<26; i++) if( freqChars[i] < freqWord[i]) {
                canBeFormed = false;
                break;
            }
            if ( canBeFormed) count += word.length();
        }
        return count;
    }
}
