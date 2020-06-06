import java.util.*;

class P1431KidsWithTheGreatestNumberOfCandies {
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for ( int num : candies ){
            max = Math.max(max, num);
        }
        
        for ( int num: candies){
            if ( num+extraCandies >= max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }

}
