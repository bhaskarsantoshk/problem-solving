class P2390RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for ( char c: s.toCharArray() ){
            if ( c == '*' ){
                sb.setLength(sb.length()-1);
            } else {
                sb.append(c+"");
            }
        }
        return sb.toString();
    }
}