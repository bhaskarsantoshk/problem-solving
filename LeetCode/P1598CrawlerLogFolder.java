package LeetCode;

public class P1598CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int count =0;
        for ( String command : logs ){
            if ( command.equals("../")) {
                if (count > 0) count--;
            }
            else if ( command.equals("./")) continue;
            else count++;
        }
        return Math.max(count, 0);
    }

    public static void main(String[] args){
        P1598CrawlerLogFolder obj = new P1598CrawlerLogFolder();
        System.out.println(obj.minOperations(new String[]{"./","../","./"}));
    }
}
