package interviewbit.strings;

public class LengthofLastWord {
    public int lengthOfLastWord(final String A) {
        int i=A.length()-1;
        int index1=0 , index2=0;
        while ( i>=0){
            while ( i>=0 && A.charAt(i)==' '){
                i--;
            }
            index1 = i;
            System.out.println(index1);
            while( i>=0 && A.charAt(i) != ' '){
                i--;
            }
            index2 = i;

            System.out.println(index2);
            break;
        }
        return index1-index2;
    }

    public static void main(String[] args){
        LengthofLastWord obj = new LengthofLastWord();
        System.out.println(obj.lengthOfLastWord(" Batman "));
    }
}
