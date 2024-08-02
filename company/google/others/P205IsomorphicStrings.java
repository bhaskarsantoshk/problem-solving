package company.google.others;

public class P205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if ( s== null && t==null) return true;
        if ( s== null || t==null ) return false;
        if ( s.isEmpty() && t.isEmpty() ) return true;
        if ( s.isEmpty() || t.isEmpty() ) return false;
        if ( s.length() != t.length()) return false;
        int a[] = new int[256];
        int b[] = new int[256];
        for ( int i=0; i<s.length(); i++){
            if ( a[s.charAt(i)] != b[t.charAt(i)]) return false;
            a[s.charAt(i)] = b[t.charAt(i)] = i+1;
        }
        return true;
    }
}
