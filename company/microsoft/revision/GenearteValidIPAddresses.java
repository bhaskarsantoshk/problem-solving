package company.microsoft.revision;

import java.util.ArrayList;
import java.util.List;

public class GenearteValidIPAddresses {
    public List<String> generateIp(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, "", res);
        return res;
    }

    private void dfs(String s, int idx, int parts, String seg, List<String> res) {
        if ( parts == 4){
            if ( idx == s.length()) res.add(seg);
            return;
        }

        for ( int len=1; len<=3 && idx+len <= s.length(); len++){
            String part = s.substring(idx, idx+len);
            if ( validIpSegment(part)) dfs(s, idx+len, parts+1, (parts == 0)? part: seg+"."+part, res);
        }
    }

    private boolean validIpSegment(String part) {
        return !(part.length() > 1 && part.charAt(0) == '0') && Integer.parseInt(part) <=255;
    }

}
