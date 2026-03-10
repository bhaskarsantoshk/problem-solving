package company.apple;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitNLinesIntoMBuckets {
    public static void main(String[] args) throws Exception {
        String filePath = new String("/Users/santosh/learn/problem-solving/Guide.md");
        split(filePath, 4);

    }

    private static void split(String filePath, int m) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<List<String>> buckets = new ArrayList<>();
        for ( int i=0; i<m; i++) buckets.add(new ArrayList<>());
        String line;
        int index = 0;
        while ( (line = reader.readLine()) != null){
            buckets.get(index%m).add(line);
            index++;
        }
        reader.close();
    }
}
