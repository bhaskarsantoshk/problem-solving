package LeetCode.explore.top_interview_questions.easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int newResult[] = new int[digits.length+1];
        newResult[0]=1;
        return newResult;
    }
}
