class P139DecryptStringFromAlphabetToIntegerMapping {
   public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ) {
            if(i < s.length() - 2 && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                char c = (char)(num + 'a');
                sb.append(c+"");
                i = i + 3;
                continue;
            }
            char c = (char)('a' +  (Integer.parseInt(String.valueOf(s.charAt(i))) - 1 )); 
            sb.append(c+"");
            i++;
        }
        return sb.toString();
    }
}
