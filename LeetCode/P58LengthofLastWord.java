package LeetCode;

public class P58LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int start = -1, end =-1, len = 0;
        for(int i= s.length()-1; i>=0; i--){
            if(end == -1 && s.charAt(i)!=' '){
                end = i;
            }
            else if(end != -1 && s.charAt(i)==' '){
                start = i+1;
                len = end -start + 1;
                break;
            }
        }
        if(start == -1 && end == -1){
            return 0;
        }
        else if(end !=-1 && start == -1){
            return end+1;
        }
        return len;
    }
}
