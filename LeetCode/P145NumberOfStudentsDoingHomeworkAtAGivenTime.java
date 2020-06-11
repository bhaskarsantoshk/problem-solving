package LeetCode;

public class P145NumberOfStudentsDoingHomeworkAtAGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for ( int i=0; i<startTime.length; i++){
            if ( endTime[i] >= queryTime && startTime[i]<= queryTime){
                res++;
            }
        }
        return res;
    }
}
