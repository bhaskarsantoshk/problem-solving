package company.google.arrays;

public class P844BackspaceStringCompare {
    public boolean backspaceCompareWithSpace(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        for ( char c: s.toCharArray()){
            if ( c == '#'){
                if ( !sb1.isEmpty() ) sb1.deleteCharAt(sb1.length()-1);
            } else {
                sb1.append(c);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for ( char c: t.toCharArray()){
            if ( c == '#'){
                if ( !sb2.isEmpty() ) sb2.deleteCharAt(sb2.length()-1);
            } else {
                sb2.append(c);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }

    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int skipS = 0, skipT = 0;

        while ( i >= 0 || j >= 0){
            while ( i >=0 ){ // Find position of next possible char in build(S)
                if ( s.charAt(i)=='#') { i--; skipS++;}
                else if ( skipS > 0) { i--; skipS--;}
                else break;
            }

            while ( j >= 0){ // Find position of next possible char in build(t)
                if ( t.charAt(j) == '#'){ j--; skipT++;}
                else if ( skipT > 0) {j--; skipT--;}
                else break;
            }
            // If two actual characters are different
            if ( i>= 0 && j>=0){
                if ( s.charAt(i) != t.charAt(j)) return false;
            }
            // If expecting to compare char vs nothing
            if ( (i>=0) != (j>=0)) return false;
            i--;j--;
        }
        return true;
    }
}
