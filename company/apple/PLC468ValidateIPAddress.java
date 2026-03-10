package company.apple;

public class PLC468ValidateIPAddress {
    // IPv4 : 32 bits , xxx.xxx.xxx.xxx ( 4 * 8 bits )
    // IPv6: 128 bits, 8 hexadecimal groups separated by :


    public String validIPAddress(String queryIP) {
        if ( queryIP.contains(".")){
            String[] parts = queryIP.split("\\.", -1); // "123.23.3.4."
            if ( parts.length != 4) return "Neither";
            for ( String part: parts){
                if ( !checkIPv4Part(part)) return "Neither";
            }
            return "IPv4";
        } else if ( queryIP.contains(":")){
            String[] parts = queryIP.split(":", -1);
            if ( parts.length != 8) return "Neither";
            for ( String part: parts){
                if ( !checkIPv6Part(part)) return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    private boolean checkIPv6Part(String part) {
        if ( part.length() == 0 || part.length() > 4) return false;
        for ( char c: part.toCharArray()){
            if ( !Character.isDigit(c) && !(c >= 'a' && c <='f') && !(c>='A' && c <= 'F')) return false;
        }
        return true;
    }

    private boolean checkIPv4Part(String part) {
        if ( part.length() == 0 || part.length() > 3) return false;
        if ( part.length() > 1 && part.charAt(0) == '0') return false;
        try{
            int num = Integer.parseInt(part);
            return  ( num>=0 && num <= 255);
        } catch (NumberFormatException e){
            return false;
        }
    }
}
