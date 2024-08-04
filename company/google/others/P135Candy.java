package company.google.others;

import java.util.Arrays;

public class P135Candy {
    public int candyBruteForce(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        boolean hasChanged = true;
        while ( hasChanged){
            hasChanged = false;
            for ( int i=0; i<ratings.length; i++){
                if ( i>0 && ratings[i] > ratings[i-1] && candies[i] <= candies[i-1] ){
                    candies[i] = candies[i-1]+1;
                    hasChanged = true;
                }

                if ( i!= ratings.length-1 && ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]){
                    candies[i] = candies[i+1]+1;
                    hasChanged = true;
                }
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    public int candy2Arrays(int[] ratings) {
        int [] leftToRight = new int[ratings.length];
        Arrays.fill(leftToRight, 1);
        for ( int i=1; i<ratings.length; i++){
            if ( leftToRight[i] <= leftToRight[i-1] && ratings[i] > ratings[i-1]){
                leftToRight[i] = leftToRight[i-1]+1;
            }
        }
        int[] rightToLeft = new int[ratings.length];
        Arrays.fill(rightToLeft, 1);
        for ( int i=ratings.length-2; i>=0 ; i--){
            if ( rightToLeft[i] <= rightToLeft[i+1] && ratings[i] > ratings[i+1]){
                rightToLeft[i] = rightToLeft[i+1]+1;
            }
        }

        int candy = 0;
        for ( int i=0; i<ratings.length; i++){
            candy += Math.max( leftToRight[i], rightToLeft[i]);
        }
        return candy;
    }

    public int candyOneArrayLinear(int[] ratings) {
        int [] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for ( int i=1; i<ratings.length; i++){
            if ( candies[i] <= candies[i-1] && ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        int sum = candies[candies.length-1];
        for ( int i=ratings.length-2; i>=0 ; i--){
            if (  ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum += candies[i];
        }

        return sum;
    }

    public int candyOnePassConstantSpace( int[] ratings ){
        int sum = 1, i=1;
        int n = ratings.length;
        while ( i < n){
            if ( ratings[i] == ratings[i-1]){
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while ( i < n && ratings[i] > ratings[i-1]){
                peak += 1;
                sum += peak;
                i++;
            }
            int down = 1;
            while ( i < n && ratings[i] < ratings[i-1]){
                sum += down;
                i++;
                down++;
            }
            if ( down > peak) sum += down-peak;
        }
        return sum;
    }

}
