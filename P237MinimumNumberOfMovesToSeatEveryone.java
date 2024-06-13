package LeetCode;

public class P237MinimumNumberOfMovesToSeatEveryone {

    // 1 3 5
    // 2 4 7

    // 1 4 5 9
    // 1 2 3 6

    // 2 2 6 6
    // 1 2 3 6


    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int res = 0;
        for ( int i=0; i<seats.length; i++){
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
