package company.confluent;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TailNLines {

    // Create a logger for this class
    private static final Logger logger = Logger.getLogger(TailNLines.class.getName());

    public static List<String> tail(File file, int n) throws Exception {
        List<String> result = new ArrayList<>();
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        long fileLength = file.length() - 1;
        int lines = 0;
        StringBuilder sb = new StringBuilder();

        // Start reading from the end of the file
        for (long pointer = fileLength; pointer >= 0; pointer--) {
            raf.seek(pointer);
            char c = (char) raf.read();

            if (c == '\n') {
                lines++;
                if (lines == n + 1) {
                    break;
                }
                result.add(sb.reverse().toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        // Add the last line
        if (sb.length() > 0) {
            result.add(sb.reverse().toString());
        }

        raf.close();
        // Reverse the result since we added lines in reverse order
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        try {
            File file = new File("yourfile.txt");
            List<String> last100Lines = tail(file, 100);

            for (String line : last100Lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            // Use logger instead of printStackTrace
            logger.log(Level.SEVERE, "An error occurred while reading the file.", e);
        }
    }
}