package company.google.arrays;

public class P158ReadNCharactersGivenRead4IICallMultipleTimes {
    private char[] prevBuffer = new char[4];
    private int prevIndex = 0;
    private int prevSize = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

        int currentIndex = 0;

        // Check to ensure we don't read more than n
        while(currentIndex < n) {

            // Using 'read4' we could have read more than n in the previous call
            // In such event, we want to first continue reading from there
            // In the first call we'll directly go to else clause as both prevIndex and prevSize will be 0
            if (prevIndex < prevSize) {
                buf[currentIndex] = prevBuffer[prevIndex];
                currentIndex++;
                prevIndex++;
            }
            // We are done reading from prevBuffer, so we can fetch new data
            // Since it's new data we need to reset the prevIndex
            else {
                prevIndex = 0;
                prevSize = read4(prevBuffer);
            }

            // If we got nothing back on calling read4, we are at the eof, hence done!
            if (prevSize == 0) break;
        }
        return currentIndex;
    }

    private int read4(char[] buf) {
        return 0;
    }
}
