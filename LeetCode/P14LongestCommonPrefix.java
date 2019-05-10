package LeetCode;

public class P14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs== null || strs.length==0){
            return "";
        }
        int index=1;
        String pre= strs[0];
        while(index < strs.length){
            while(strs[index].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length()-1);
            }
            index++;
        }
        return pre;
    }
}
