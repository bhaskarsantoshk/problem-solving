package LeetCode;

public class P551StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int count = 0;
        for ( char c: s.toCharArray()){
            if ( c == 'A') count++;
        }
        return ! ( (count > 1) || s.indexOf("LLL") >= 0 );
    }
}
