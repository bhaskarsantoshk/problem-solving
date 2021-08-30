package company.amazon.leetcode;

public class P273IntegerToEnglishWords {
    String[] tens = {"", "Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    public String numberToWords(int num) {
        if ( num <= 0) return "Zero";
        return helper(num).trim();
    }

    private String helper(int num) {
        if ( num >= 1000000000 ) return helper(num/1000000000) + " Billion "+helper(num % 1000000000);
        if ( num >= 1000000) return helper(num/1000000) + " Million "+ helper(num % 1000000);
        if ( num >= 1000 ) return helper(num/1000) + " Thousand "+ helper(num % 1000);
        if ( num >= 100 ) return (helper(num/100) + " Hundred "+ helper(num % 100)).trim();;
        if ( num >= 20 ) return (tens[num/10]+ " " + helper(num%10)).trim();;
        return ones[num];
    }
}
