package LeetCode;

import java.util.Arrays;

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


    public int minMovesToSeatOptimized(int[] seats, int[] students) {
        int maxPosition = Math.max(findMax(seats), findMax(students));
        int diff[] = new int[maxPosition];

        // count available seats at given position
        for ( int seatPos: seats){
            diff[seatPos-1]++;
        }

        // remove student for each position
        for ( int studentPos: students){
            diff[studentPos-1]--;
        }

        // number of moves to seat the students
        int moves = 0;
        int unmatched = 0;
        for ( int difference: diff){
            moves += Math.abs(unmatched);
            unmatched += difference;
        }
        return moves;
    }

    private int findMax(int[] nums) {
        int max= 0;
        for ( int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }
}


// Proof : https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/solutions/5305223/greedy-figure-proof-sort-counting-sort-1-liner-0ms-beats-100/
