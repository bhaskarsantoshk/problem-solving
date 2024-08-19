package company.google;

public class P6502KeysKeyboard {
    public int minSteps(int n) {
        return f(n);
    }

    private int f(int n) {
        if ( n == 1 ) return 0;
        int minOpeartions = n;
        for ( int i=2; i<=n ; i++){
            if ( n%i==0) {
                int operations = minSteps(n/i)+i;
                minOpeartions = Math.min(minOpeartions, operations);
            }
        }
        return minOpeartions;
    }

}
