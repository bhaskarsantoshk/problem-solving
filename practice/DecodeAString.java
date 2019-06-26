package practice;

public class DecodeAString {
    public static void main(String[] args){
        String s= "3a3b10c12d";
        //StringBuffer is a list of strings that get appended
        StringBuffer result= new StringBuffer();
        //Count of each character to be printed ( E.g. 3a -> count =3 )
        int count=0;
        //Traverse through each character of the input
        for(int i=0; i<s.length(); i++){
            //store one character at a time
            char c= s.charAt(i);
            // If character is a number , we will extract the number,
            // if the number has multiple digits, the below code will compute that number
            if(c>= '0' && c <='9'){
                int number = Integer.parseInt(c+"");
                count = count * 10 + number;
            }
            else{
                // c is not a number means whatever is the count till now should be the frequency of c
                for(int j=0; j<count; j++){
                    result.append(c);
                }
                count=0;
            }
        }

        System.out.println(result.toString());
    }
}
