package company.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        // cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
        // for each string:
        //  split using " " : first part (convert into number) , second part is domain
        // for second part - traverse each char, anytime you encounter a . , put substring(index+1) into map & increase count
        // at the end put second part into map & increase count
        // from the map - create a list of the right format
        Map<String, Integer> map = new HashMap<>();
        for ( String domainInfo: cpdomains){
            String[] domainArr = domainInfo.split(" ");
            int count = Integer.parseInt(domainArr[0]);
            String domain = domainArr[1];
            for ( int i=0; i<domain.length(); i++){
                if ( domain.charAt(i) == '.'){
                    String subDomain = domain.substring(i+1);
                    map.put(subDomain, map.getOrDefault(subDomain, 0)+count);
                }
            }
            map.put(domain, map.getOrDefault(domain,0)+ count);
        }

        List<String> result = new ArrayList<>();
        for ( String subDomain: map.keySet()){
            result.add( map.get(subDomain)+" "+ subDomain);
        }
        return result;
    }
}
