package company.google;

public class P482LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = s.length()-1;
        while ( count < k && index >= 0){
            char c = s.charAt(index);
            index--;
            if ( c == '-') continue;
            sb.append(Character.toUpperCase(c));
            count++;
            if ( count == k) {
                sb.append("-");
                count = 0;
            }
        }
        if (!sb.isEmpty() && sb.charAt(sb.length()-1) == '-') sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }

    // ahb-oj-18iml-l
    // LLMI-81JO-BHA

    //----
}
