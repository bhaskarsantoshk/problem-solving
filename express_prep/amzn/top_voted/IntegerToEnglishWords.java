package express_prep.amzn.top_voted;

public class IntegerToEnglishWords {
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    public String numberToWords(int num) {
        if ( num <= 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        if ( num >= 1000000000) return (helper(num/1000000000) +" Billion "+ helper(num%1000000000)).trim();
        if ( num >= 1000000) return (helper(num/1000000)+" Million "+ helper(num % 1000000)).trim();
        if ( num >= 1000 ) return (helper(num/1000) + " Thousand "+ helper(num%1000)).trim();
        if ( num >= 100 ) return (helper(num/100) + " Hundred "+ helper(num%100)).trim();
        if ( num >= 20 ) return tens [num/10] + ones[num%10];
        return ones[num];
    }
}
