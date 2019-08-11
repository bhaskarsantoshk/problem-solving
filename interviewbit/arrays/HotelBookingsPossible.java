package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int i=0, j=0, roomsRequired = 0;
        while ( i< arrive.size() && j< depart.size() && roomsRequired <= K){
            if ( arrive.get(i) < depart.get(j)){
                i++;
                roomsRequired++;
            }
            else{
                j++;
                roomsRequired--;
            }
        }
        return roomsRequired <= K;
    }
}
