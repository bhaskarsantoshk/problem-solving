package company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class GenearteValidIPAddresses {
    public List<String> generateIp(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, res, "");
        return res;
    }

    private void dfs(String s, int idx, int parts, List<String> res, String segment) {
        if ( parts == 4){
            if( idx == s.length()) res.add(segment);
            return;
        }

        for ( int len=1; len<=3 && idx+len <= s.length(); len++){
            String part = s.substring(idx, idx+len);
            if ( !valid(part)) continue;
            dfs(s, idx+len, parts+1, res, parts == 0 ? part : segment + "." + part);
        }
    }

    private boolean valid(String s) {
        return !(s.length() > 1 && s.charAt(0) == '0') && Integer.parseInt(s) <= 255;
    }
}
