package company.google;

public class P1554StringsDifferByOneCharacter {
    public boolean differByOne(String[] dict) {
        for ( int i=0; i<dict.length; i++){
            for ( int j=i+1; j< dict.length; j++) {
                String a = dict[i];
                String b = dict[i + 1];
                if (a.length() != b.length()) continue;

                int count = 0;
                for ( int k=0; k<a.length(); k++){
                    if ( a.charAt(k) != b.charAt(k)) count++;
                }
                if ( count == 1) return true;
            }
        }
        return false;
    }
}
