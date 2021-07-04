package data_structures.arrays;

public class NextLetter {
    public static char getNextLetterInACircularList(char[] letters, char key) {
        if ( key < letters[0] || key > letters[letters.length-1]){
            return letters[0];
        }
        int start = 0, end = letters.length-1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( letters[mid] < key){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return letters[start%(letters.length)];

    }
}
