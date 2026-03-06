package company.apple;

public class P42ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int a[] = new int[256];
        for ( char c:s.toCharArray()){
            a[c]++;
        }
        for ( char c: t.toCharArray()){
            a[c]--;
        }

        for ( int num: a){
            if ( num != 0) return false;
        }
        return true;
    }
}
