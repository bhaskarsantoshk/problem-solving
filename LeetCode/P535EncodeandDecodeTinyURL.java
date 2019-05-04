package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P535EncodeandDecodeTinyURL {
    Map<String, String> map = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = generateKey();
        map.put(key, longUrl);
        return key;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
    public String generateKey(){
        String s= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int min=0, max= 61, range = 62;
        for(int i=0; i<6; i++){
            int index= (int)(Math.random() * range) + min;
            sb.append(s.charAt(index));
        }
        String key= sb.toString();
        if(map.containsKey(key)){
            return generateKey();
        }
        return key;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));